package com.neo.v1.service;

import com.neo.v1.client.RewardsClient;
import com.neo.v1.mapper.FailItemUpdateRequestMapper;
import com.neo.v1.mapper.RewardsRequestMapper;
import com.neo.v1.model.trigger.model.FailItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerItem;
import com.neo.v1.model.trigger.model.TriggerItemUpdateRequest;
import com.neo.v1.model.trigger.type.TriggerStatus;
import com.neo.v1.rewards.model.RewardsWorkerRequest;
import com.neo.v1.rewards.model.RewardsWorkerResponses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
public class WorkerService {

    private final RewardsClient rewardsClient;
    private final TriggerService triggerService;
    private final RewardsRequestMapper rewardsRequestMapper;
    private final FailItemUpdateRequestMapper failItemUpdateRequestMapper;

    public void rewardsWorker(TriggerItem triggerItem) {
        try {
            RewardsWorkerRequest request = rewardsRequestMapper.map(triggerItem);
            RewardsWorkerResponses rewardsWorkerResponses = rewardsClient.putRewardsWorker(request);
            if (Objects.nonNull(rewardsWorkerResponses.getData().getNextExecutionDate())) {
                Long id = triggerService.getTriggerByExternalId(triggerItem.getExternalId(), triggerItem.getType()).getData().getId();
                triggerService.updateTriggerItem(TriggerItemUpdateRequest.builder()
                        .nextExecutionDate(LocalDateTime.parse(rewardsWorkerResponses.getData().getNextExecutionDate()))
                        .status(TriggerStatus.OPEN)
                        .id(id)
                        .build());
            } else {
                triggerService.closeTrigger(triggerItem);
            }
        } catch (Exception e) {
            FailItemUpdateRequest failRequest = failItemUpdateRequestMapper.map(triggerItem, e);
            triggerService.postFailure(failRequest);
        }

    }
}
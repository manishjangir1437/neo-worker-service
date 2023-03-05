package com.neo.v1.mapper;

import com.neo.v1.model.trigger.model.TriggerItem;
import com.neo.v1.rewards.model.RewardsWorkerRequest;
import org.springframework.stereotype.Component;

@Component
public class RewardsRequestMapper {

    public RewardsWorkerRequest map (TriggerItem triggerItem) {
         return RewardsWorkerRequest.builder()
                 .externalId(triggerItem.getExternalId())
                 .type(triggerItem.getType())
                 .build();
    }

}

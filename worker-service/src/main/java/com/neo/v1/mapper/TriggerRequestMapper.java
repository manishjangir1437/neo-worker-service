package com.neo.v1.mapper;

import com.neo.v1.model.trigger.model.CloseItemUpdateRequest;
import com.neo.v1.model.trigger.model.FailItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerItem;
import com.neo.v1.model.trigger.model.TriggerItemCreateRequest;
import com.neo.v1.model.trigger.model.TriggerItemUpdateRequest;
import com.neo.v1.model.trigger.type.TriggerStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TriggerRequestMapper {

    public TriggerItemCreateRequest mapCreateRequest(TriggerItem triggerItem, String type) {
        return TriggerItemCreateRequest.builder()
                .externalId(triggerItem.getExternalId())
                .nextExecutionDate(triggerItem.getNextExecutionDate())
                .context(triggerItem.getContext())
                .type(type)
                .build();
    }

    public FailItemUpdateRequest mapFailItemUpdateRequest(TriggerItem triggerItem, String failureReason) {
        return FailItemUpdateRequest.builder()
                .id(triggerItem.getId())
                .failure(failureReason)
                .build();
    }

    public CloseItemUpdateRequest mapCloseItemRequest(TriggerItem triggerItem) {
        return CloseItemUpdateRequest.builder()
                .id(triggerItem.getId())
                .build();
    }

    public TriggerItemUpdateRequest mapTriggerItemUpdateRequest(Long id, String context, TriggerStatus triggerStatus) {
        return mapTriggerItemUpdateRequest(id, context, triggerStatus, null);
    }

    public TriggerItemUpdateRequest mapTriggerItemUpdateRequest(Long id, String context, TriggerStatus triggerStatus, LocalDateTime nextExecutionDate) {
        return TriggerItemUpdateRequest.builder()
                .id(id)
                .context(context)
                .status(triggerStatus)
                .nextExecutionDate(nextExecutionDate)
                .build();
    }

    public TriggerItemCreateRequest mapCreateRequest(Long externalId, String type) {
        return TriggerItemCreateRequest.builder()
                .externalId(String.valueOf(externalId))
                .type(type)
                .build();
    }
}

package com.neo.v1.mapper;

import com.neo.v1.model.DocumentMessageRequest;
import com.neo.v1.model.trigger.model.TriggerItem;
import org.springframework.stereotype.Component;

@Component
public class DocumentMessageRequestMapper {

    public TriggerItem map(DocumentMessageRequest request) {
        return TriggerItem.builder()
                .externalId(request.getExternalId())
                .version(request.getVersion())
                .type(request.getType())
                .status(request.getStatus())
                .id(request.getId())
                .failure(request.getFailure())
                .context(request.getContext())
                .nextExecutionDate(request.getNextExecutionDate())
                .retries(request.getRetries())
                .build();
    }
}

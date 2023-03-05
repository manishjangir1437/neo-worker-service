package com.neo.v1.mapper;

import com.neo.v1.model.trigger.model.FailItemUpdateRequest;
import com.neo.v1.model.trigger.model.TriggerItem;
import org.springframework.stereotype.Component;

@Component
public class FailItemUpdateRequestMapper {

    public FailItemUpdateRequest map(TriggerItem triggerItem, Exception e){
        return FailItemUpdateRequest.builder()
                .id(triggerItem.getId())
                .failure(e.getMessage())
                .build();
    }

}

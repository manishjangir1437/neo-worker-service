package com.neo.v1.processor;

import com.neo.v1.model.trigger.model.TriggerItem;

import java.time.LocalDateTime;

public interface DocumentStateData {
    TriggerItem getTriggerItem();

    void setTriggerItem(TriggerItem info);

    LocalDateTime getNextExecutionDate();

    void setNextExecutionDate(LocalDateTime nextExecutionDate);
}
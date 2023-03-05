package com.neo.v1.processor;

import com.neo.v1.model.trigger.model.TriggerItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonProcessorStateData implements DocumentStateData {
    private TriggerItem triggerItem;
    private LocalDateTime nextExecutionDate;
}

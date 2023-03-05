package com.neo.v1.processor;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RewardsFactory {

    private final ApplicationContext ctx;


    public Rewards getProcessor(String processorName) {
        return StringUtils.isNotBlank(processorName) ? ctx.getBean(processorName, Rewards.class) : null;
    }

}

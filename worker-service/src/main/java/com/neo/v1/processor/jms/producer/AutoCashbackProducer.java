package com.neo.v1.processor.jms.producer;

import com.neo.v1.model.trigger.model.TriggerItem;
import com.neo.v1.reader.PropertyReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile({"local", "dev"})
@Slf4j
public class AutoCashbackProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private PropertyReader propertyReader;

    public void produceMessage(TriggerItem task) {
        log.info("producing task context :{}, externalId :{} ", task.getContext(), task.getExternalId());
        jmsTemplate.convertAndSend(propertyReader.getWorkerAutoCashbackQueue(), task);
    }

}

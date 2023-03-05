package com.neo.v1.processor.jms.consumer;

import com.neo.v1.model.trigger.model.TriggerItem;
import com.neo.v1.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_AUTO_CASHBACK_QUEUE;
import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_AUTO_MILES_QUEUE;
import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_EARNED_TOKENS_QUEUE;
import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_ENROLLMENT_QUEUE;
import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_PROGRAM_UPDATE_QUEUE;
import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_REDEMPTION_MILES_SETTLEMENT_QUEUE;
import static com.neo.v1.constants.WorkerConstants.WORKER_REWARDS_REDEMPTION_STATUS_QUEUE;

@Slf4j
@Component
@RequiredArgsConstructor
public class RewardsConsumer {

    private final WorkerService workerService;

    @JmsListener(destination = WORKER_REWARDS_AUTO_CASHBACK_QUEUE)
    @JmsListener(destination = WORKER_REWARDS_AUTO_MILES_QUEUE)
    @JmsListener(destination = WORKER_REWARDS_EARNED_TOKENS_QUEUE)
    @JmsListener(destination = WORKER_REWARDS_ENROLLMENT_QUEUE)
    @JmsListener(destination = WORKER_REWARDS_PROGRAM_UPDATE_QUEUE)
    @JmsListener(destination = WORKER_REWARDS_REDEMPTION_STATUS_QUEUE)
    @JmsListener(destination = WORKER_REWARDS_REDEMPTION_MILES_SETTLEMENT_QUEUE)
    public void consumeRewardsMessage(TriggerItem triggerItem) {
        log.info("Message received! - rewards - {}", triggerItem.getContext());
        workerService.rewardsWorker(triggerItem);
    }
}
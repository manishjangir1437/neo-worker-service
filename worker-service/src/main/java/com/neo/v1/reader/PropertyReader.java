package com.neo.v1.reader;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PropertyReader {

    @Value("${rewards.worker.jms.queue.url}")
    private String rewardsWorkerQueueUrl;

    @Value("${rewards.worker.jms.queue.user}")
    private String rewardsWorkerQueueUser;

    @Value("${rewards.worker.jms.queue.password}")
    private String rewardsWorkerQueuePasswd;

    @Value("${rewards.worker.jms.queue.consumers.maxMessages}")
    private int rewardsWorkerMaxConsumeMessages;

    @Value("${rewards.worker.jms.queue.consumers.concurrency}")
    private String rewardsWorkerConsumersConcurrency;

    @Value("${rewards.worker.jms.queue.taskPool.corePoolSize}")
    private int rewardsWorkerCorePoolSize;

    @Value("${rewards.worker.jms.connectionPool.trustAllPackages}")
    private boolean rewardsWorkerJmsTrustPackages;

    @Value("${rewards.worker.jms.connectionPool.blockIfSessionPoolIsFull}")
    private boolean rewardsWorkerBlockPoolIfFull;

    @Value("${rewards.worker.jms.connectionPool.blockIfSessionPoolIsFullTimeout}")
    private long rewardsWorkerBlockPoolTimeout;

    @Value("${rewards.worker.jms.queue.taskPool.maxPoolSize}")
    private int rewardsWorkerMaxPoolSize;

    @Value("${rewards.worker.jms.queue.taskPool.queueCapacity}")
    private int rewardsWorkerTaskQueueCapacity;

    @Value("${rewards.worker.jms.queue.taskPool.threadNamePrefix}")
    private String rewardsWorkerThreadNamePrefix;

    @Value("${rewards.worker.jms.queue.taskPool.keepAliveSeconds}")
    private int rewardsWorkerTaskKeepAlive;

    @Value("${rewards.worker.jms.connectionPool.maxLimit}")
    private int rewardsWorkerMaxJmsConnections;

    @Value("${rewards.worker.jms.queue.consumers.type.rewards.program.update}")
    private String workerProgramUpdateQueue;

    @Value("${rewards.worker.jms.queue.consumers.type.rewards.auto.cashback}")
    private String workerAutoCashbackQueue;

    @Value("${rewards.worker.jms.queue.consumers.type.rewards.auto.miles}")
    private String workerAutoMilesQueue;

    @Value("${rewards.worker.jms.queue.consumers.type.rewards.enrollment}")
    private String workerEnrollmentQueue;

    @Value("${rewards.worker.jms.queue.consumers.type.rewards.redemption.status}")
    private String workerRedemptionStatusQueue;

    @Value("${rewards.worker.jms.queue.consumers.type.rewards.earned.tokens}")
    private String workerEarnedTokensQueue;

    @Value("${rewards.worker.opswat.key}")
    private String opswatKey;

    @Value("${rewards.worker.opswat.private.processing}")
    private Integer opswatPrivateProccessing;

    @Value("${rewards.worker.opswat.rule}")
    private String opswatRule;

    @Value("${rewards.worker.aws.s3.base.url}")
    private String awsS3BaseUrl;
}
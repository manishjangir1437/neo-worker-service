package com.neo.v1.config;

import com.neo.v1.async.AsyncThreadRejectionHandler;
import com.neo.v1.reader.PropertyReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import java.util.concurrent.Executor;

@Component
@EnableJms
@RequiredArgsConstructor
@Slf4j
public class RewardsWorkerJmsConfig {

    private final PropertyReader propertyReader;

    @Bean
    @Primary
    public PooledConnectionFactory connectionFactory() {
        log.info("Queue URL: {}", propertyReader.getRewardsWorkerQueueUrl());
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(propertyReader.getRewardsWorkerQueueUser(),
                propertyReader.getRewardsWorkerQueuePasswd(), propertyReader.getRewardsWorkerQueueUrl());
        connectionFactory.setTrustAllPackages(propertyReader.isRewardsWorkerJmsTrustPackages());
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(connectionFactory);
        pooledConnectionFactory.setMaxConnections(propertyReader.getRewardsWorkerMaxJmsConnections());
        pooledConnectionFactory.setBlockIfSessionPoolIsFull(propertyReader.isRewardsWorkerBlockPoolIfFull());
        pooledConnectionFactory.setBlockIfSessionPoolIsFullTimeout(propertyReader.getRewardsWorkerBlockPoolTimeout());
        return pooledConnectionFactory;
    }


    @Bean
    public JmsListenerContainerFactory<DefaultMessageListenerContainer> segmentWorkerListenerFactory(@Autowired MessageConverter converter, DefaultJmsListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(converter);
        factory.setMaxMessagesPerTask(propertyReader.getRewardsWorkerMaxConsumeMessages());
        factory.setConcurrency(propertyReader.getRewardsWorkerConsumersConcurrency());
        factory.setTaskExecutor(asyncExecutor());
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    @Primary
    public JmsTemplate jmsTemplate(@Autowired MessageConverter converter, ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setMessageConverter(converter);
        return template;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    private Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(propertyReader.getRewardsWorkerCorePoolSize());
        executor.setMaxPoolSize(propertyReader.getRewardsWorkerMaxPoolSize());
        executor.setQueueCapacity(propertyReader.getRewardsWorkerTaskQueueCapacity());
        executor.setThreadNamePrefix(propertyReader.getRewardsWorkerThreadNamePrefix());
        executor.setKeepAliveSeconds(propertyReader.getRewardsWorkerTaskKeepAlive());
        executor.setRejectedExecutionHandler(new AsyncThreadRejectionHandler());
        executor.initialize();
        log.debug("Initialized task-executor for JMS-Queue");
        return executor;
    }

}
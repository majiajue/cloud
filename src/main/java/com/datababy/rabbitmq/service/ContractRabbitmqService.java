package com.datababy.rabbitmq.service;

import com.datababy.rabbitmq.enity.ContractRabbitmq;
import com.datababy.rabbitmq.enity.TenantRabbitmq;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yongma on 2017/2/8.
 */
@Service
public class ContractRabbitmqService implements RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    public void sendContractRabbitmqTopic(final ContractRabbitmq ContractRabbitmq) {
        this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.CONTRACT_TOPIC, RabbitmqQueue.CONTRACE_SELF, ContractRabbitmq);
    }

    public void sendContractRabbitmqDirect(final ContractRabbitmq ContractRabbitmq) {
        this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.CONTRACT_DIRECT, RabbitmqQueue.CONTRACE_SELF, ContractRabbitmq);
    }

    public void sendTenantRabbitmqTopic(final TenantRabbitmq tenantRabbitmq){
        this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.CONTRACT_TOPIC, RabbitmqQueue.CONTRACE_TENANT, tenantRabbitmq);
    }


    public void sendTenantRabbitmqDirect(final TenantRabbitmq tenantRabbitmq){
        this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.CONTRACT_DIRECT, RabbitmqQueue.CONTRACE_TENANT, tenantRabbitmq);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println(correlationData.getId()+"消息确认成功:"+s);
        } else {
            System.out.println(correlationData.getId()+"消息确认失败"+s);
        }
    }
}

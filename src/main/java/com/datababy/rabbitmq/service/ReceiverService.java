package com.datababy.rabbitmq.service;

import com.datababy.rabbitmq.enity.ContractRabbitmq;
import com.datababy.rabbitmq.enity.TenantRabbitmq;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by yongma on 2017/2/8.
 */
@Component
public class ReceiverService {

    @RabbitListener(queues = RabbitmqQueue.CONTRACE_SELF)
    public void receiveContractQueue(ContractRabbitmq contract) {
        System.out.println("Received contract<" + new Gson().toJson(contract) + ">");
    }

    @RabbitListener(queues = RabbitmqQueue.CONTRACE_TENANT)
    public void receiveTenantQueue(TenantRabbitmq tenant) {
        System.out.println("Received Bar<" + new Gson().toJson(tenant) + ">");
    }
}

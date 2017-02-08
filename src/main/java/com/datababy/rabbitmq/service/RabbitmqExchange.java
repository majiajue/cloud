package com.datababy.rabbitmq.service;

/**
 * Created by yongma on 2017/2/8.
 */
public interface RabbitmqExchange {
    /**
     * 合同exchange
     */
    final String CONTRACT_FANOUT = "CONTRACT_FANOUT";
    final String CONTRACT_TOPIC = "CONTRACT_TOPIC";
    final String CONTRACT_DIRECT = "CONTRACT_DIRECT";
}

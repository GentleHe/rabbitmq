package com.study.rabbitmq.producer;

import com.study.rabbitmq.entity.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发消息
    public void send(Order order){
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessage_id());

        /**
         * exchange
         * routingKey
         * object   消息体内容
         * correlationData 指定消息体的唯一ID
         */
        rabbitTemplate.convertAndSend("order-exchange", "order.abcd", order, correlationData);

    }

}

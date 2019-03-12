package com.study.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;

import com.study.rabbitmq.entity.Order;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class OrderReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(value = "order-exchange", durable = "true", type = "topic"),
            key = "order.*"
    ))
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        //消费者操作
        System.out.println("---------收到消息,开始消费-------");
        System.out.println("订单ID " + order.getOrder_id());

        Long deliveryTage = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //ACK     手动签收,回送响应
        channel.basicAck(deliveryTage, false);

    }

}

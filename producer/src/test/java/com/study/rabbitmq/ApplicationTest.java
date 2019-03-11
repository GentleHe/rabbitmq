package com.study.rabbitmq;

import com.study.rabbitmq.entity.Order;
import com.study.rabbitmq.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private OrderSender orderSender;

    @Test
    public void test1(){
        Order order = new Order();
        order.setOrder_id("2019-3-11-0001");
        order.getOrder_name("测试订单0001");
        order.setMessage_id(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());
        orderSender.send(order);
    }

}

package com.study.rabbitmq.entity;

import java.io.Serializable;

/**
 * 订单实体类
 *  一定要实现序列化
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -1502291609049620042L;

    private String order_id;
    private String order_name;

    //存储消息发送的唯一ID
    private String message_id;

    public Order(String order_id, String order_name, String message_id) {
        this.order_id = order_id;
        this.order_name = order_name;
        this.message_id = message_id;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", order_name='" + order_name + '\'' +
                ", message_id='" + message_id + '\'' +
                '}';
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name(String 测试订单) {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }
}

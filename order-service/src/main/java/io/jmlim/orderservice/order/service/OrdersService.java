package io.jmlim.orderservice.order.service;

import io.jmlim.orderservice.order.dto.OrderDto;
import io.jmlim.orderservice.order.entity.Order;

public interface OrdersService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<Order> getOrdersByUserId(String userId);
}

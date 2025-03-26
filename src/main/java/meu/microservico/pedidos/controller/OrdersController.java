package meu.microservico.pedidos.controller;

import meu.microservico.pedidos.model.Orders;
import meu.microservico.pedidos.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrderService orderService;
    private final RabbitTemplate rabbitTemplate;

    public OrdersController(RabbitTemplate rabbitTemplate, OrderService orderService) {
        this.rabbitTemplate = rabbitTemplate;
        this.orderService = orderService;
    }

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    @PostMapping
    public String createOrder(@RequestBody Orders order) {
        Orders savedOrder = orderService.saveOrder(order);
        rabbitTemplate.convertAndSend("", routingKey, savedOrder.getDescription());
        return "Order successfully saved and is now being processed: " + savedOrder.getDescription();
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getOrders();
    }
}
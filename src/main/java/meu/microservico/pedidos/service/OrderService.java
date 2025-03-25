package meu.microservico.pedidos.service;

import meu.microservico.pedidos.model.ItemOrders;
import meu.microservico.pedidos.model.Orders;
import meu.microservico.pedidos.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrdersRepository ordersRepository;

    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders saveOrder(Orders order) {
        if(order.getItens() != null) {
            for (ItemOrders item : order.getItens()) {
                item.setOrder(order);
            }
        }
        return ordersRepository.save(order);
    }

    public List<Orders> getOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
}

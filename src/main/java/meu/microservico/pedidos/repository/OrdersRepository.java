package meu.microservico.pedidos.repository;

import meu.microservico.pedidos.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}

package meu.microservico.pedidos.repository;

import meu.microservico.pedidos.model.ItemOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrdersRepository extends JpaRepository<ItemOrders, Long> {
}

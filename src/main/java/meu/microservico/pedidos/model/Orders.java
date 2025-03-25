package meu.microservico.pedidos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemOrders> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public List<ItemOrders> getItens() {
        return this.itens;
    }

    public void setItens(List<ItemOrders> itens) { this.itens = itens; }
}

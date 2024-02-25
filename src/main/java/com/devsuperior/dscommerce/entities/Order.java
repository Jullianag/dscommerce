package com.devsuperior.dscommerce.entities;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    // Lado muitos do relacionamento um para muitos
    // Classe Order com um relacionamento muitos para um com User
    // Mapear o lado "um" do relacionamento, que é o User
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

}

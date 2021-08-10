package com.tomtom.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cart")
public class CartEntity {
    @SequenceGenerator(name = "cart_sequence" , sequenceName = "cart_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cart_sequence")
    @Id
    private Long id;

    private String productName;

    private Long productId;

    private BigDecimal productPrice;

    private int quantity;

    private boolean payment;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private UserEntity user;


}

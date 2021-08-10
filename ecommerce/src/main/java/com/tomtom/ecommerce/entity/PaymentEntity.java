package com.tomtom.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaymentEntity {

    @SequenceGenerator(name = "payment_sequence" , sequenceName = "payment_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "payment_sequence")
    @Id
    private long paymentId;

    private String userName;

    private long userId;

    private String transaction_id;

    private String cardNumber;

    private String modeOfPayment;

    private BigDecimal paymentAmount;

    private Integer numberOfItem;

}

package com.tomtom.ecommerce.dao;

import com.tomtom.ecommerce.entity.PaymentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestBody {

    private PaymentEntity payment;
}

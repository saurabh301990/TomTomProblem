package com.tomtom.ecommerce.service;

import com.tomtom.ecommerce.dao.PaymentRequestBody;
import com.tomtom.ecommerce.response.PaymentResponse;

public interface PaymentService {

    PaymentResponse payment(PaymentRequestBody paymentRequestBody) throws Exception;
}

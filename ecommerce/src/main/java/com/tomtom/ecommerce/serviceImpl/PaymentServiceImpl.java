package com.tomtom.ecommerce.serviceImpl;

import com.tomtom.ecommerce.dao.PaymentRequestBody;
import com.tomtom.ecommerce.entity.CartEntity;
import com.tomtom.ecommerce.entity.PaymentEntity;
import com.tomtom.ecommerce.repoistory.AddProductToCartRepo;
import com.tomtom.ecommerce.repoistory.PaymentRepo;
import com.tomtom.ecommerce.response.PaymentResponse;
import com.tomtom.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    AddProductToCartRepo addProductToCartRepo;

    @Override
    public PaymentResponse payment(PaymentRequestBody paymentRequestBody) throws Exception {
        PaymentEntity payment = paymentRequestBody.getPayment();
        List<CartEntity> cartItem = getItemInCart(payment.getUserId());
        payment.setNumberOfItem( cartItem.size());

        payment.setPaymentAmount(getTotalAmount(cartItem));
        payment.setTransaction_id(generateTransactionId());
       payment = paymentRepo.save(payment);

        if(payment != null){
          updatePaymentStatusInCart(cartItem);
          return  new PaymentResponse("Payment Successful with Transaction ID "+payment.getTransaction_id() );
        }else {
            return new PaymentResponse("Payment Unsuccessful");
        }


    }

    private String generateTransactionId() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        return uuidAsString;
    }


    private List<CartEntity> getItemInCart(long userID) {
        return addProductToCartRepo.findByUserId(userID);
    }

    public BigDecimal getTotalAmount(List<CartEntity> cartEntities){
        BigDecimal totalAmount = new BigDecimal(0.0);
        for (CartEntity cart: cartEntities) {
            BigDecimal quantity = new BigDecimal(cart.getQuantity());
            BigDecimal amount = quantity.multiply(cart.getProductPrice());
            totalAmount = totalAmount.add(amount);
        }
        return totalAmount;
    }

    private void updatePaymentStatusInCart(List<CartEntity> cartEntities ){
        for (CartEntity entity:
             cartEntities) {
            entity =addProductToCartRepo.findByProductByProductIdAndUserId(entity.getProductId(),entity.getUser().getUserId());
            entity.setPayment(true);
            addProductToCartRepo.save(entity);

        }
    }
}

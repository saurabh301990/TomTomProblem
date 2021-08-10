package com.tomtom.ecommerce.repoistory;

import com.tomtom.ecommerce.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentEntity,Long> {
}

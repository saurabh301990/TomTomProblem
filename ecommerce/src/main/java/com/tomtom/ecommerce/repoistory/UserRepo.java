package com.tomtom.ecommerce.repoistory;

import com.tomtom.ecommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);
}

package com.tomtom.ecommerce.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {


    @SequenceGenerator(name = "user_sequence" , sequenceName = "user_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
    @Column(name = "user_id")
    @Id
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email",nullable = false)
    private String email;



}

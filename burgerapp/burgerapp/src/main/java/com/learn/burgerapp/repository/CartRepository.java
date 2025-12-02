package com.learn.burgerapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.burgerapp.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}

package com.learn.burgerapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.UUID)

private String id;

private String name;

private String passowrd;

private int age;

@Column(unique = true)
private Cart cart;
}

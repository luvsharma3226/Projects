package com.dailycodebuffer.spring.data.jpa.tutorial.entity.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(schema = "products")
@Data
public class Product {

    @Id
    private int id;

    private String name;

    private double price;
}
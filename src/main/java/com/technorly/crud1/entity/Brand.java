package com.technorly.crud1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    public static final int BRAND_NAME_MAX_LENGTH = 40;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

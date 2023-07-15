package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected long id;

    public long getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }
}

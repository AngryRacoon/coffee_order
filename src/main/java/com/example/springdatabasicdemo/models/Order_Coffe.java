package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Order_Coffe")
public   class Order_Coffe  {
    @Id
    @Column(name = "Coffe_ID")
    protected int coffe_id;
    @Basic
    @Column(name = "Count")
    private int count;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id", referencedColumnName = "Coffe_id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Coffe group;

    public Order_Coffe(int count)
    {
        this.count = count;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Order_Coffe(){
    }

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }
/*
    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }

 */
}

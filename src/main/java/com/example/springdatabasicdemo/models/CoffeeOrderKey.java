package com.example.springdatabasicdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CoffeeOrderKey implements Serializable {

        @Column(name = "coffee_id")
        Long coffeeId;

        @Column(name = "order_id")
        Long orderId;

        // standard constructors, getters, and setters
        // hashcode and equals implementation

        public CoffeeOrderKey() {
                // Default constructor required by Hibernate
        }

        public CoffeeOrderKey(Long coffeeId, Long orderId) {
                this.coffeeId = coffeeId;
                this.orderId = orderId;
        }

        public Long getCoffeeId() {
                return coffeeId;
        }

        protected void setCoffeeId(Long id) {
                this.coffeeId = id;
        }

        public Long getOrderId() {
                return orderId;
        }

        protected void setOrderId(Long id) {
                this.orderId = id;
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((coffeeId == null) ? 0 : coffeeId.hashCode());
                result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
                return result;
        }

        // equals implementation
        @Override
        public boolean equals(Object obj) {
                if (this == obj) {
                        return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                        return false;
                }
                CoffeeOrderKey other = (CoffeeOrderKey) obj;
                return Objects.equals(coffeeId, other.coffeeId) &&
                        Objects.equals(orderId, other.orderId);
        }
}

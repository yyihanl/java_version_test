package com.example.dto;

import java.util.Objects;
import java.util.Set;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private Set<OrderDTO> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, orders);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "\n" +
                "    id=" + id + ",\n" +
                "    name='" + name + '\'' + ",\n" +
                "    email='" + email + '\'' + ",\n" +
                "    orders=" + orders + 
                '}';
    }
}
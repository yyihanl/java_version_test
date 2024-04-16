package com.example.dto;
import java.util.Objects;

public class OrderDTO {

    private Long id;
    private CustomerDTO customer;
    private ProductDTO product;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return quantity == orderDTO.quantity && Objects.equals(id, orderDTO.id) && Objects.equals(customer, orderDTO.customer) && Objects.equals(product, orderDTO.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, product, quantity);
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "\n" + 
                "    id=" + id + ",\n" +
                "    customer=" + customer + ",\n" +
                "    product=" + product + ",\n" +
                "    quantity=" + quantity + 
                '}';
    }
}

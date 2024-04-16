package com.example.project;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.model.Product;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.service.ProductService;
import com.example.controller.CrudController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CrudControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private ProductService productService;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private CrudController crudController;

    private Customer customer;
    private Product product;
    private Order order;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customer = new Customer();
        product = new Product();
        order = new Order();
    }

    @Test
    public void testCreateCustomer() {
        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        ResponseEntity<Customer> response = crudController.createCustomer(customer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = Arrays.asList(customer, new Customer());
        when(customerService.getAllCustomers()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = crudController.getAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    public void testCreateProduct() {
        when(productService.createProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = crudController.createProduct(product);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = Arrays.asList(product, new Product());
        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<Product>> response = crudController.getAllProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    public void testCreateOrder() {
        when(orderService.createOrder(any(Order.class))).thenReturn(order);

        ResponseEntity<Order> response = crudController.createOrder(order);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = Arrays.asList(order, new Order());
        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<Order>> response = crudController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }
}
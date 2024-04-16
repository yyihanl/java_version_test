package com.example.controller;

import com.example.model.Customer;
import com.example.model.Order;
import com.example.model.Product;
import com.example.service.CustomerService;
import com.example.service.OrderService;
import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CrudController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(CrudController.class);

    // Customer endpoints
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        logger.info("Customer created: {}", createdCustomer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customerNames")
    public ResponseEntity<String[]> getAllCustomerNames() {
        List<Customer> customers = customerService.getAllCustomers();
        List<String> customerNames = customers.stream()
                                      .map(Customer::getName)
                                      .collect(Collectors.toList());
        // convert list to array
        String[] customerNamesArray = customerNames.toArray(new String[0]);

        return new ResponseEntity<>(customerNamesArray, HttpStatus.OK);
    }

    // Product endpoints
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PostMapping("/productImage")
    public ResponseEntity<byte[]> getProductImage(@RequestBody long productId) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            final byte[] image;
            //try {
                //image = new BASE64Decoder().decodeBuffer(product.getImageBase64());
                //return new ResponseEntity<>(image, HttpStatus.CREATED);
                return null;
            //} catch (IOException e) {
            //    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            //}
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Order endpoints
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        switch (orders.size()){
            case 0:
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                logger.info("Small order. Only contains: {}", orders.size());
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                logger.info("Medium order. Contains: {}", orders.size());
            default:
                logger.info("Large order. Contains: {}", orders.size());
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
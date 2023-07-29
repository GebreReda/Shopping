package com.onlineshopping.onlineshoppingproject.service;

import com.onlineshopping.onlineshoppingproject.dto.OrderRequest;
import com.onlineshopping.onlineshoppingproject.model.*;
import com.onlineshopping.onlineshoppingproject.repository.CustomerRepository;
import com.onlineshopping.onlineshoppingproject.repository.InventoryRepository;
import com.onlineshopping.onlineshoppingproject.repository.OrderRepository;
import com.onlineshopping.onlineshoppingproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class OrderService {
    private KafkaTemplate<String, String> kafkaTemplate;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    private InventoryRepository inventoryRepository;

    @Autowired
    public OrderService(CustomerRepository customerRepository,
                        ProductRepository productRepository,
                        OrderRepository orderRepository,
                        InventoryRepository inventoryRepository) {
                        this.customerRepository = customerRepository;
                        this.productRepository = productRepository;
                        this.orderRepository = orderRepository;
                        this.inventoryRepository=inventoryRepository;
    }

    //Product
    //Save a Product
    public void postProduct(Product product) {
        productRepository.save(product);
    }

    //Get all Products
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    //Order
    //Save an order
    public String postOrder(OrderRequest orderRequest) {

        List<Product> orderProducts = orderRequest.getProductList();
        List<Inventory> stockProducts = inventoryRepository.findAll();

        boolean orderIsAvailable = areOrderRequestsAvailableInStock(orderProducts, stockProducts);

        if (orderIsAvailable) {
            //check balance
            //Customer has enough balance to pay the sum
            double balance = orderRequest.getCustomer().getBankAccount().getBalance();
            double amount = orderRequest.getProductList().stream().mapToDouble(Product::getPrice).sum();
            System.out.println("Balance is: "+balance);
            System.out.println("Amount is: "+amount);
            if(balance >= amount){
                balance = balance - amount;
                System.out.println("Balance is: "+balance);
                Customer customer = orderRequest.getCustomer();
                BankAccount bank = orderRequest.getCustomer().getBankAccount();
                bank.setBalance(bank.getBalance()-amount);
                customer.setBankAccount(bank);
                customerRepository.save(customer);
            }
            else
                throw new RuntimeException("Insufficient funds!");


            //save order table
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setCustomer(orderRequest.getCustomer());
            order.setProductList(orderRequest.getProductList());
            orderRepository.save(order);

            //update the inventory table
            for (Product product : orderProducts) {
                String requestedSkuCode = product.getSkuCode();
                int requestedQuantity = product.getQuantity();

                // Find the product in stock with the requested skuCode
                Inventory productInStock = stockProducts.stream()
                        .filter(pro -> (pro.getSkuCode().equals(requestedSkuCode) &&
                                pro.getQuantity() >= requestedQuantity))
                        .findFirst()
                        .orElse(null);

                if (productInStock != null) {
                    productInStock.setQuantity(productInStock.getQuantity() - product.getQuantity());
                    inventoryRepository.save(productInStock);
                }
            }
            kafkaTemplate.send("test1","Order saved successfully");
            return "Order saved successfully";
        } else return "Order is not saved!";
    }

    //Get all Order
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    // Method to check if a set of order requests is available in stock
    public static boolean areOrderRequestsAvailableInStock(List<Product> orderProducts, List<Inventory> stock) {
        for (Product product : orderProducts) {
            String requestedSkuCode = product.getSkuCode();
            int requestedQuantity = product.getQuantity();

            // Find the product in stock with the requested skuCode
            Inventory productInStock = stock.stream()
                    .filter(pro -> pro.getSkuCode().equals(requestedSkuCode))
                    .findFirst()
                    .orElse(null);

            // If the product is not available or its quantity is insufficient, return false
            if (!isProductAvailableInStock(productInStock, requestedQuantity))
                return false;
        }
        return true; // All order requests are available in stock
    }
    private static boolean isProductAvailableInStock(Inventory product, int requestedQuantity) {
        return product != null && product.getQuantity() >= requestedQuantity;
    }
}

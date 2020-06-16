package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        return  orderRepository.save(order);
    }

    public  Optional<Order> getOrderById(Long id)  {
        Optional<Order>  order = orderRepository.findById(id);
        return  order;
    }

     public Order updateOrderById(Long id, Order order){
         order.setOrderid(id);
         return orderRepository.save(order);
     }

     public  void  deleteOrderById(Long id){
         orderRepository.deleteById(id);

     }






}

package com.stacksimplify.restservices.controllers;
import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repository.OrderRepository;
import com.stacksimplify.restservices.repository.UserRepository;
import com.stacksimplify.restservices.services.OrderService;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("{userid}/orders")
    public List<Order> getOrdersByUser(@PathVariable Long userid) throws  UserNotFoundException{

        Optional<User> optionalUser = userRepository.findById(userid);
        if (!optionalUser.isPresent())
            throw  new UserNotFoundException("User Not Found");
         return optionalUser.get().getOrder();
    }

    @GetMapping
    public List<Order>  getAllOrders(){
        return  orderService.getAllOrders();
    }

    @PostMapping("{userid}/orders")
    public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException{
        Optional<User>  optionalUser = userRepository.findById(userid);
        if (!optionalUser.isPresent())
            throw  new UserNotFoundException("User not found brother try the id exist in the database son");
        User user = optionalUser.get();
        order.setUser(user);
        return orderRepository.save(order);


    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") @Min(1) Long id){
            return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public  Order  updateOrderById(@PathVariable("id") Long id, @RequestBody Order order){
            return orderService.updateOrderById(id, order);

    }

    @DeleteMapping("/{id}")
    public  void  deleteOrderById(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
    }




}

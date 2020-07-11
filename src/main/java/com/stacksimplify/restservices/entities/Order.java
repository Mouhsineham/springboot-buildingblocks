package com.stacksimplify.restservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name = "orders")
public class Order extends ResourceSupport{
    @Id
    @GeneratedValue
    private Long orderid;
    private String orderdescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;



    public Order() {
        super();
    }

    public Order(Long orderid, String orderdescription, User user) {
        this.orderid = orderid;
        this.orderdescription = orderdescription;
        this.user = user;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

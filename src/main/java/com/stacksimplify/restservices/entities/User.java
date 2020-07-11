package com.stacksimplify.restservices.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Entity
@Table(name = "user")
public class User extends ResourceSupport{
    @Id
    @GeneratedValue
    private Long userid;
    @NotEmpty(message = "Username is Mandatory field. please provide  username")
    @Column(name ="USER_NAME", length = 50, nullable = false, unique = true)
    private String username;
    @Size(min = 2, message = "Firstname should have at least 2 characters")
    @Column(name ="FIRST_NAME", length = 50, nullable = false)
    private String firstname;
    @Column(name ="LAST_NAME", length = 50, nullable = false)
    private String lastname;
    @Column(name ="EMAIL_ADDRESS", length = 50, nullable = false)
    private String email;
    @Column(name ="ROLE", length = 50, nullable = false)
    private String role;
    @Column(name ="SSN", length = 50, nullable = false, unique = true)
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    public User() {
    }

    public User(Long  userid, String username, String firstname, String lastname, String email, String role, String ssn,List<Order> orders) {
        this.userid=userid;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
        this.order=orders;
    }
    //18 344

    public Long getUserid() {
        return userid;
    }

    public void setId(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                ", order=" + order +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}

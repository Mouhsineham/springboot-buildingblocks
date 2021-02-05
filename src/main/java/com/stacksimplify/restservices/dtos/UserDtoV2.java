package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

public class UserDtoV2 {

	private Long userid;
	private String username;
	private String firstname;
	private String email;
	private String role;
	private String ssn;
	private List<Order> order;
	private String address;
	
	public UserDtoV2(Long userid, String username, String firstname, String email, String role, String ssn,
			List<Order> order,String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.order = order;
		this.address =  address;
	}
	public UserDtoV2() {

	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}

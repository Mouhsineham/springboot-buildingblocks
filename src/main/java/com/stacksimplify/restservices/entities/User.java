package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This model is to create a user" )
@Entity
@Table(name = "user")
//Ignore multiple fields
//@JsonIgnoreProperties({"username", "firstname"}) -- Static Filtering @JsonIgnore
//@JsonFilter(value = "userFilter") -- User for Mapping JacksonValue filtering section
public class User extends ResourceSupport {
	@ApiModelProperty(notes = "Auto generated unique id", required = true, position = 1 )
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private Long userid;
	
	@ApiModelProperty(notes = "usename should in format flname",example = "kreddy", required = false, position = 2 )
	@Size(min = 2, max = 50)
	@NotEmpty(message = "Username is Mandatory field. please provide  username")
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@JsonView(Views.External.class)
	private String username;

	@Size(min = 2, max = 50, message = "Firstname should have at least 2 characters")
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String firstname;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	@Column(name = "EMAIL_ADDRESS", length = 50, nullable = false)
	@JsonView(Views.External.class)
	private String email;

	@Column(name = "ROLE", length = 50, nullable = false)
	@JsonView(Views.Internal.class)
	private String role;

	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	// ignore one field
	// @JsonIgnore
	@JsonView(Views.Internal.class)
	private String ssn;

	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> order;

	@Column(name = "ADDRESS")
	private String address;

	public User() {
	}

	public User(Long userid,
			@NotEmpty(message = "Username is Mandatory field. please provide  username") String username,
			@Size(min = 2, message = "Firstname should have at least 2 characters") String firstname, String lastname,
			String email, String role, String ssn, List<Order> order, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.order = order;
		this.address = address;
	}

	public Long getUserid() {
		return userid;
	}

	public void setId(Long userid) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + ", order=" + order + ", address="
				+ address + "]";
	}

}

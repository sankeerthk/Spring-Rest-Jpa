package io.jpa.employee;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="JPA_EMPLOYEE")
@NamedQueries({
	@NamedQuery(name="employee.findAll",query="SELECT e FROM Employee e ORDER BY e.firstName"),
	@NamedQuery(name="employee.findByEmail",query="SELECT e FROM Employee e WHERE e.email=:pemail")
})
public class Employee {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String email;
	private LocalDateTime createdTime;

	
	public Employee()	{
		this.id= UUID.randomUUID().toString();
		this.createdTime=LocalDateTime.now();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	

}

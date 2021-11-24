package model.entities;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	private String customer_name;
	
	public Order() {}
	
	public Order(LocalDate date, String customer_name)
	{
		this.setDate(date);
		this.setCustomerName(customer_name);
	}
	
	public int getId()
	{
		return this.id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getCustomerName() {
		return customer_name;
	}

	public void setCustomerName(String customer_name) {
		this.customer_name = customer_name;
	}
}
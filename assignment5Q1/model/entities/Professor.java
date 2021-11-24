package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor
{
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String office;
	private String research;
    
    @OneToOne
    @JoinColumn(name="customer_id", nullable=false, cascade = CascadeType.ALL)	
	private Customer customer;
	
	public Professor() {}
	
	public Professor(String office, String research, Customer customer)
	{
		this.setOffice(office);
		this.setResearch(research);
		this.setCustomer(customer);
	}
	
	public int getId() {
		return this.id;
	}

	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getResearch() {
		return this.research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}

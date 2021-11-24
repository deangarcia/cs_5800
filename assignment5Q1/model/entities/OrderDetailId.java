package model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3908983137643904474L;
	
	private Order order;
	private Product product;
	
	public OrderDetailId() {}
	
	public OrderDetailId(Order order, Product product)
	{
		this.setOrder(order);
		this.setProduct(product);
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Order getOrder()
	{
		return this.order;
	}
	
	public void setOrder(Order order)
	{
		this.order = order;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Product getProduct()
	{
		return this.product;
	}
	
	public void setProduct(Product product)
	{
		this.product = product;
	}
}
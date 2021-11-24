package model.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "order_detail")
@AssociationOverrides({
	@AssociationOverride(name = "product",
		joinColumns = @JoinColumn(name = "product_id")),
	@AssociationOverride(name = "order",
		joinColumns = @JoinColumn(name = "order_id")) })
public class OrderDetail 
{
	private OrderDetailId primary_key = new OrderDetailId();
	
	public OrderDetail() {}
	
	public OrderDetail(OrderDetailId primary_key)
	{
		this.setPrimaryKey(primary_key);
	}
	
	@EmbeddedId
	public OrderDetailId getPrimaryKey()
	{
		return this.primary_key;
	}
	
	public void setPrimaryKey(OrderDetailId primary_key)
	{
		this.primary_key = primary_key;
	}
	
	@Transient
	public Order getOrder()
	{
		return this.getPrimaryKey().getOrder();
	}
	
	public void setOrder(Order order)
	{
		this.getPrimaryKey().setOrder(order);
	}
	
	@Transient
	public Product getProduct()
	{
		return this.getPrimaryKey().getProduct();
	}
	
	public void setProduct(Product product)
	{
		this.getPrimaryKey().setProduct(product);
	}
}

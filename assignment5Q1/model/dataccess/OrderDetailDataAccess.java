package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.OrderDetail;
import model.entities.OrderDetailId;
import model.business.HibernateUtil;

public class OrderDetailDataAccess {
	public void saveOrderDetail(OrderDetail order_detail)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(order_detail);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
	}
	
	public List<OrderDetail> getAllOrderDetails()
	{
		Transaction transaction = null;
		List<OrderDetail> order_details = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			order_details = (List<OrderDetail>)session.createQuery("FROM OrderDetail", OrderDetail.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return order_details;
	}

	public OrderDetail deleteOrderDetail(OrderDetailId primary_key)
	{
		Transaction transaction = null;
		OrderDetail order_detail = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			order_detail = session.get(OrderDetail.class, primary_key);
			session.delete(order_detail);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return order_detail;
	}

}

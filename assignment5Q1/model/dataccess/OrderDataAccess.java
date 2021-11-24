package model.dataccess;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Order;
import model.business.HibernateUtil;

public class OrderDataAccess {
	public void saveOrder(Order order)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(order);
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
	
	public List<Order> getAllOrders()
	{
		Transaction transaction = null;
		List<Order> orders = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			orders = (List<Order>)session.createQuery("FROM Order", Order.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return orders;
	}

	public Order deleteOrder(int id)
	{
		Transaction transaction = null;
		Order order = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			order = session.get(Order.class, id);
			session.delete(order);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return order;
	}

}
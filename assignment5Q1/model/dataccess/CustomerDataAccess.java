package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Customer;
import model.business.HibernateUtil;

public class CustomerDataAccess {
	
	public void saveCustomer(Customer customer)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(customer);
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

    public List<Customer> getAllCustomers()
	{
		Transaction transaction = null;
		List<Customer> customers = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			customers = (List<Customer>)session.createQuery("FROM Customer", Customer.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return customers;
	}

	public Customer deleteCustomer(int id)
	{
		Transaction transaction = null;
		Customer customer = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			customer = session.get(Customer.class, id);
			session.delete(customer);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return customer;
	}
}

package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Product;
import model.business.HibernateUtil;

public class ProductDataAccess {
	public void saveProduct(Product product)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(product);
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
	
	public List<Product> getAllProducts()
	{
		Transaction transaction = null;
		List<Product> products = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			products = (List<Product>)session.createQuery("FROM Product", Product.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return products;
	}

	public Product deleteProduct(int id)
	{
		Transaction transaction = null;
		Product product = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			product = session.get(Product.class, id);
			session.delete(product);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return product;
	}

}

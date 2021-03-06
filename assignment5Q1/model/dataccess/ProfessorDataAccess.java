package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Professor;
import model.business.HibernateUtil;

public class ProfessorDataAccess 
{
	public void saveProfessor(Professor professor)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(professor);
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

    public List<Professor> getAllProfessors()
	{
		Transaction transaction = null;
		List<Professor> professors = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			professors = (List<Professor>)session.createQuery("FROM Professor", Professor.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return professors;
	}

	public Professor deleteProfessor(int id)
	{
		Transaction transaction = null;
		Professor professor = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			professor = session.get(Professor.class, id);
			session.delete(professor);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return professor;
	}
}
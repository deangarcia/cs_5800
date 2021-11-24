package model.business;

import java.util.List;

import model.dataccess.CustomerDataAccess;
import model.dataccess.ProfessorDataAccess;
import model.entities.Customer;
import model.entities.Professor;

public class MainDelete {

	public static void main(String[] args) 
    {		
		CustomerDataAccess customerDa = new CustomerDataAccess();
		
		ProfessorDataAccess professorDa = new ProfessorDataAccess();

        List<Customer> customers = customerDa.getAllCustomers();

        for(Customer temp: customers)
        {
            customerDa.deleteCustomer(temp.getId());
        }

        List<Professor> professors = professorDa.getAllProfessors();

        if(professors.isEmpty())
        {
            System.out.println("Elements Deleted");
        }
        
        for(Professor temp: professors)
        {
            // Should be empty
            System.out.println(temp.getCustomer().getName());
        }
	}
}
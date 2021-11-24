package model.business;

import java.util.List;

import model.dataccess.CustomerDataAccess;
import model.dataccess.ProfessorDataAccess;
import model.entities.Customer;
import model.entities.Professor;

public class MainCreate {

	public static void main(String[] args) 
    {
		CustomerDataAccess customerDa = new CustomerDataAccess();
		Customer customer = new Customer("Brian Nelson", "address 1");
        Customer customer_delete = new Customer("Will Smith", "address 2");
		customerDa.saveCustomer(customer);
        customerDa.saveCustomer(customer_delete);
		
		ProfessorDataAccess professorDa = new ProfessorDataAccess();
		Professor professor = new Professor("CS-551", "AI", customer);
        Professor professor_delete = new Professor("CS-334", "Algorithms", customer_delete);
		professorDa.saveProfessor(professor);

        List<Customer> customers = customerDa.getAllCustomers();

        for(Customer temp: customers)
        {
            System.out.println(temp.getName());
        }

        List<Professor> professors = professorDa.getAllProfessors();

        for(Professor temp: professors)
        {
            System.out.println(temp.getCustomer().getName());
        }
	}
}
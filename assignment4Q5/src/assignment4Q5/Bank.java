package assignment4Q5;

public class Bank {

	public static void main(String[] args) 
	{
		CorporateHolder c_holder = new CorporateHolder(1,"442 test ln", "951-xxx-xxxx");
		Account c_account = new Account(100, c_holder);
		System.out.println();
		System.out.print(c_account);
		
		IndividualHolder i_holder = new IndividualHolder(2,"442 test ln", "bob", "3333333");
		Account i_account = new Account(1000, i_holder);
		System.out.println();
		System.out.print(i_account);
	}
}

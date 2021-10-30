package assignment4Q5;

public class AccountHolder {
	protected int ID;
	protected String address; 
	
	public AccountHolder(int ID, String address)
	{
		this.ID = ID;
		this.address = address;
	}
	
	public int nextID()
	{
		return this.ID + 1;
	}
}

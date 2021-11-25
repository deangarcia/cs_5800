package assignment5Q5;

public class Prime {
	
	public Prime(){}
	
	public boolean isPrime(int number)
	{
		if (number <= 1)
		{
            return false;
		}
        else
        {
            return !isDivisible(number, 2);
        }
	}
	
	public boolean isDivisible(int number, int divisor) 
	{
        if (divisor >= number)
        {
            return false;
        }
        else if (number % divisor == 0)
        {
            return true;
        }
        else
        {
            return isDivisible(number, divisor+1);
        }
    }
}

package pack1;

// Savings.java

public class Savings extends Account
{
	
	
	
	private double interestRate = .05;
	private double interestEarned;
	
	// constructor
	public Savings(String accountNumber)
	{
		super(accountNumber);
		this.interestEarned = 0.00;	
	}
	
	// set interest earned
	public void setInterestEarned(double interestEarned)
	{
		this.interestEarned = interestEarned;
	}
	
	// return interest earned
	public double getInterestEarned()
	{
		return interestEarned;
	}
	
	// calc interest
	public double computeInterest()
	{
		return interestEarned = ((interestRate * computeAverageBalance()) / 12);
	}
	
	// print statement
	@Override
	public void printStatement()
	{
		super.printStatement();
		System.out.printf("Interest Earned: $%.2f%n_________________________________________", this.getInterestEarned());	   
	}
	
	// calc avg balance
	@Override
	public double computeAverageBalance()
	{
		return (this.transactionCheck() / 2) + (this.getBalance() / 2);
	}
	
}	// end class Savings
package pack1;

// Checking.java

public class Checking extends Account
{
	private double totalFee;
	
	// constructor
	public Checking(String accountNumber)
	{
		super(accountNumber);
		this.totalFee = 0.0;	
	}
	
	
	// compute fee
	public void computeFee()
	{
		if (this.getOwner().getStatus().equalsIgnoreCase("regular") && this.computeAverageBalance() < 500.00)
		{
			totalFee = 35.00;
		}else if (this.getOwner().getStatus().equalsIgnoreCase("regular") && this.computeAverageBalance() > 500.00)
		{
			totalFee = 15.00;
		}else if (this.getOwner().getStatus().equalsIgnoreCase("premier") && this.computeAverageBalance() < 500.00)
		{
			totalFee = 10.00;
		}else
		{
			totalFee = 0.0;
		}
	}
	
	// print statement
	@Override
	public void printStatement()
	{
		super.printStatement();
		System.out.printf("Total Fee: $%.2f%n_________________________________________", this.totalFee);
		   
	}
		
	// calc avg balance
	@Override
	public double computeAverageBalance()
	{
		return (getLowBalance() / 2) + (getHighBalance() / 2);
	}
	
	
	
	
	
	
}	// end class Checking

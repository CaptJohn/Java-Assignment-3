package pack1;

// AccountTest.java
// Inputting and outputting floating-point numbers with Account objects.
import java.util.Scanner;

public class AccountTest
{
	private static Customer[] customerArray;
	private static Account[] accountArray;
	
	// Main method begins execution of Java app
	public static void main(String[] args)
   {
	  
	  // create a Scanner to obtain input from the command window
	  Scanner input = new Scanner(System.in);

	  System.out.print("Please enter number of customers: "); // Prompt for # of customers
	  int customerQuantity = input.nextInt(); // get # of customers
	 
	  customerArray = new Customer[customerQuantity];
	  
	  System.out.print("Please enter number of accounts: "); // Prompt for # of accounts
	  int accountQuantity = input.nextInt(); // get # of accounts
	  
	  accountArray = new Account[accountQuantity];

	  for(int counter = 0, custLength = customerArray.length; counter < custLength; counter++)
	  {
		  System.out.println("Please enter customer first name: "); // Prompt for customer first name
		  String firstName = input.next(); // get customer first name
		  
		  System.out.println("Please enter customer last name: "); // Prompt for customer last name
		  String lastName = input.next(); // get customer last name
		  
		  System.out.println("Please enter customer status: "); // Prompt for customer status
		  String status = input.next(); // get customer status
		  
		  customerArray[counter] = new Customer (lastName, firstName, status);
	  }
	  
	 
	  
	  for(int counter = 0; counter < accountArray.length; counter++)
	  {
		  System.out.print("Please enter account number: "); //prompt for account number
		  String accountNumber = input.next(); // get account number
		  
		  System.out.print("Please enter account type: "); //prompt for account type
		  String accountType = input.next(); // get account type
		 
		  	if (accountType.equalsIgnoreCase("checking"))
		  	{
		  		accountArray[counter] = new Checking(accountNumber);
		  	}	else {
		  		accountArray[counter] = new Savings(accountNumber);
		  	}
		  
		  
		  System.out.print("Please enter customer first name: "); // Prompt for customer first name
		  String firstName = input.next(); // get customer first name
		  
		  System.out.print("Please enter customer last name: "); // Prompt for customer last name
		  String lastName = input.next(); // get customer last name
		  
		  for(Customer customer:customerArray)
		  {
			  if(customer.getFirstName().equalsIgnoreCase(firstName) && customer.getLastName().equalsIgnoreCase(lastName))
			  {
				  accountArray[counter].setOwner(customer);
			  }
		  }
		  
		  System.out.print("Please enter starting balance: "); // prompt for starting balance
	      double balance = input.nextDouble(); // obtain starting balance
	      
	      accountArray[counter].startBalance(balance);
	      
	      // select transaction type
	      System.out.print("Please enter transaction type(1=Deposit, -1=Withdrawal, 0=Quit): ");
	      int transType = input.nextInt(); // get transaction type
	      
	      while(transType != 0)
	      {
	    	  System.out.print("Please enter amount:");
	    	  double transAmount = input.nextDouble(); // get transaction amount
	    	  
	    	  System.out.print("Please enter day of month: ");
	    	  int day = input.nextInt(); // get day of month
	    	  
	    	  accountArray[counter].trans(transType, transAmount, day);
	    	    
	    	  System.out.print("Please enter transaction type(1=Deposit, -1=Withdrawal, 0=Quit): ");
	          transType = input.nextInt(); // get transaction type    
	      } 
	  }
	  
     for (Account account:accountArray)
     {
    	 account.printStatement();
     }
     
      input.close();
      
   } // end main
} // end class AccountTest

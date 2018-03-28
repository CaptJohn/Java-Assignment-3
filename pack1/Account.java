package pack1;

// MIS-515: Assignment 3 - John Shepherd
// Account.java

import java.util.ArrayList;
public abstract class Account
{   
   private String accountNumber;
   private double balance; 
   private double beginningBalance; 
   private double totalDeposits; 
   private double totalWithdrawals; 
   private double averageBalance; 
   private ArrayList<Transaction> transactionArray = new ArrayList<>();
   private Customer customerReference;
   private double highBalance;
   private double lowBalance;
   
   
   // Account constructor  
   public Account(String accountNumber) 
   {
      this.accountNumber = accountNumber; // assign account number to instance variable accountNumber   
   }

   // method that sets starting balance (adds) only a valid amount to the balance
   public void startBalance(double beginningBalance) 
   {      
      this.setBeginningBalance(beginningBalance); // set starting balance  
      this.lowBalance = this.beginningBalance;
      this.highBalance = this.beginningBalance;
      this.balance = balance + beginningBalance; // add starting balance to the balance 
   }

   // method that deposits (adds) only a valid amount to the balance
   public void deposit(double depositAmount, int day) 
   {      
      this.balance = balance + depositAmount; // add it to the balance 
      this.totalDeposits += depositAmount;
      this.transactionArray.add(new Transaction(1, day, depositAmount, "Account credited")); 
      this.highBalance = (this.balance > this.highBalance) ? this.balance:this.highBalance;
   }

   // method that withdraws (subtracts) only a valid amount from the balance
   public void withdraw(double withdrawAmount, int day) 
   {      
      this.balance = balance - withdrawAmount; // subtract it from the balance 
      this.totalWithdrawals += withdrawAmount;

      if (this.balance < 0)
      {
    	  if (this.customerReference.getStatus().equalsIgnoreCase("regular"))
    	  {
    		 this.transactionArray.add(new Transaction(-1, day, withdrawAmount, "Account is overdrawn")); 
    		 this.balance = this.balance - 40;
    	  }
    	  else
    	  {
    		 this.transactionArray.add(new Transaction(-1, day, withdrawAmount, "Account is overdrawn")); 
     		 this.balance = this.balance - 10;
    	  }
      }
      else
      {
    
      this.transactionArray.add(new Transaction(2, day, withdrawAmount, "Account debited")); 
      }
      this.lowBalance = (this.balance < this.lowBalance) ? this.balance:this.lowBalance;
   }

   // get lowBalance
   public double getLowBalance()
   {
	   return this.lowBalance;
   }

   // get highBalance
   public double getHighBalance()
   {
	   return this.highBalance;
   }

   // method that checks input type
   public void trans(int transOption, double amount, int day) 
   {      
      if(transOption == 0) {

      } else if(transOption ==1)
      {
    	  deposit(amount, day);
      } else{
    	  withdraw(amount, day);
      }
    }

   // method that returns the account balance
   public double getBalance()
   {
      return this.balance; 
   } 

   // method that sets the account number
   public void setAccountNumber(String accountNumber)
   {
      this.accountNumber = accountNumber; 
   } 

   // method that returns the account number
   public String getAccountNumber()
   {
      return this.accountNumber; 
   } 

   //method that sets owner
   public void setOwner(Customer owner)
   {
	   this.customerReference = owner;
   }
   
   // get owner
   public Customer getOwner()
   {
	   return this.customerReference;
   }
   
   // method to print account statement
   public void printStatement()
   {
	   System.out.printf("%n%n_________________________________________%nAccount Number: %s%n", this.getAccountNumber());
	   System.out.printf("Customer Name: %s%n", this.customerReference.getName());
	   System.out.printf("Beginning Balance: $%.2f%n", this.getBeginningBalance());
	   System.out.printf("Total Deposits: $%.2f%n", this.totalDeposits);
	   System.out.printf("Total Withdrawals: $%.2f%n", this.totalWithdrawals);
	   System.out.printf("Ending Balance: $%.2f%n", this.balance);
	   System.out.printf("Average Balance: $%.2f%n", this.averageBalance);
	   
	   for(Transaction transaction: this.transactionArray)
	   {
		   System.out.printf("%nTransaction Type: %s%n", transaction.getTransactionType());
		   System.out.printf("Transaction Day: %d%n", transaction.getTransactionDay());
		   System.out.printf("Transaction Message: %s%n", transaction.getMessage());
		   System.out.printf("Transaction Ammount: $%.2f%n", transaction.getAmount());
	   }
   }
  
   // method to return beginning balance
   public double getBeginningBalance() 
   {
	   return beginningBalance;
   }

   // method to set beginning balance
   public void setBeginningBalance(double beginningBalance)
	{
	   this.beginningBalance = beginningBalance;
	}

   // check for day 1 transaction
   public double transactionCheck()
   {
	   double value = 0.0;
	   if (this.transactionArray.get(0).getTransactionDay() == 1 && Integer.parseInt(this.transactionArray.get(0).getTransactionType()) == 1)
	   {
		   value = this.beginningBalance + this.transactionArray.get(0).getAmount();
	   }
	   else if(this.transactionArray.get(0).getTransactionDay() == 1 && Integer.parseInt(this.transactionArray.get(0).getTransactionType()) == -1)
	   {
		   value = this.beginningBalance - this.transactionArray.get(0).getAmount();
	   }	else{
		   value = this.beginningBalance;
	   }
	   return value;
   }
   
   // abstract method to calc avg balance
   public abstract double computeAverageBalance();

   
   
} // end class Account

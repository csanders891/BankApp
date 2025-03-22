package bank_app;

import java.util.Scanner;

class CheckLogin extends Exception{
	CheckLogin(String errormessage)
	{
		super(errormessage);
	}
	
}

class CheckAccount extends Exception{
	CheckAccount(String errormessage) 
	{
		super(errormessage);
	}
}

class Deposit extends Exception
{
	Deposit(String errormessage)
	{
		super(errormessage);
	}
	
}

class Withdraw extends Exception
{	
	Withdraw(String errormessage)
	{
	super(errormessage);
	}
	
}

class BankingUser{
	double balance = 3000;
	String Username = "csanders82";
	String Password = "Olivia2012!";
	public void checkLogin(String user_id, String pwd) throws CheckLogin
	{
		//Login to check user id and password; 
		//if user id or password not does not match while attempting 3 times, then accounts block
		
		if(Username.equals(user_id) && Password.equals(pwd))
			System.out.println("Login complete");
		
		else
		{
		 int x= 0;
		 Scanner scan = new Scanner(System.in);
		 String reentry1, reentry2;
		 
			while(x  < 2)
			{
				
				System.out.println("Incorrect login information.  Please reenter your username");
				reentry1 = scan.next();
				
				System.out.println("Please reenter your password");
				reentry2 = scan.next();
				
				if(Username == reentry1 && Password == reentry2)
				{
					System.out.println("Login complete");
					break;
				}
					
				x++;
				
			}
			
			if(x == 2)
				throw new CheckLogin("Your account is currently locked.  Call 1-800-381-5010");
		}
		
	}
	
	public void bankAccount(String acctype) throws CheckAccount
	{
		//Login to check the type of account the user should choose before depositing or withdrawing money
		System.out.println(acctype + " it is");
	}
	
	public void depositMoney(double amount) throws Deposit
	{
		//Deposit only up to $1000
		if(amount <= 1000)
		{
			balance += amount;
			
			System.out.println("Depositing $" + amount +  " into your account");
			System.out.println("Your balance is now $" + balance);
		}
			
		
		else
			throw new Deposit("That's too much");
	}
	
	public void withdrawMoney(double amount) throws Withdraw
	{
		//Withdraw only up to $1000
		if(amount <= 1000)
		{
			balance -= amount;
			
			System.out.println("Withdrawing $" + amount +  " into your account");
			System.out.println("Your balance is now $" + balance);
		}
			
		
		else
			throw new Withdraw("That's too much");
	}
}

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Option 1: check login       
		System.out.println("1. Check login");
		
		BankingUser login = new BankingUser();
		
		//Option 2: choose account type
		System.out.println("2. Choose account type");
		BankingUser account = new BankingUser();
			
		//Option 3: money deposit
		System.out.println("3. Deposit");
		BankingUser deposit = new BankingUser();
	
		//Option 4: money withdrawl
		System.out.println("4. Withdrawl");
		BankingUser withdraw = new BankingUser();
		
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		
		while(choice < 1 || choice > 4)
		{
			System.out.println("Invalid entry.  Try again");
			choice = keyboard.nextInt();
		}
		
		if(choice == 1)
		{
			System.out.println("Enter username");
			String username = keyboard.next();
			
			System.out.println("Enter password");
			String password = keyboard.next();
			
			try {
				login.checkLogin(username, password);
			} catch (CheckLogin e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		else if(choice == 2)
		{
			String accountType;
			System.out.println("1. Checking");
			System.out.println("2. Savings");
			
			int selection = keyboard.nextInt();
			
			while(selection < 1 || selection > 2)
			{
				System.out.println("Invalid entry.  Try again");
				selection = keyboard.nextInt();
			}
			
			if(selection == 1)
				 accountType = "Checking";
		
			else
				accountType = "Savings";
			
			try {
				account.bankAccount(accountType);
			} catch (CheckAccount e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(choice == 3)
		{
			System.out.println("How much do you want to deposit");
			
			double money = keyboard.nextDouble();
			
			try {
				deposit.depositMoney(money);
			} catch (Deposit e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(choice == 4)
		{
			System.out.println("How much do you want to withdraw");
			
			double money = keyboard.nextDouble();
			
			try {
				withdraw.withdrawMoney(money);
			} catch (Withdraw e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
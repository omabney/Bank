
//Account class
public class Account implements User{
	private String acName;
	private int acNumber;
	private String usName;
	private String usPassword;
	private String acType;
	private double balance;
	private String email;

	Account(String name, int acNum, String usNm, String usPass, String actype,String eml, Double bal)
	{
		acName = name;
	    acNumber = acNum;
	    usName = usNm;
	    usPassword = usPass;
	    acType = actype;
	    balance = bal;
	    email = eml;
	}

	//Method Definition for implemented class function display
	public void display()
	{
		System.out.println("\n");
		System.out.println("***Account Details***");
		System.out.println("Account name   :"+acName);
		System.out.println("Account Number : "+acNumber);
        System.out.println("Account Type   : "+acType);
		System.out.println("username  : "+usName);
		System.out.println("Password   : "+usPassword);
		System.out.println("Email  : "+email);
        System.out.println("Balance  : "+balance);
	}

    //Method Definition for implemented class function Check(Used to check username and password)
	public boolean check(String usName, String usPass)
	{
		boolean b;
		if(usPassword.equals(usPass)&&usName.equals(usName))
			b=true;
		else
			b=false;
		return b;
	}
    //Getter Method for acNumber
    public int getacNumber(){
        return acNumber;
    }
	//Method to deposit cash
	public void deposit(double cash)
	{
		System.out.println("\n");
		balance=balance+cash;
		System.out.println("***You have Successfully deposit cash***");
		System.out.println("Your current balance is "+balance);
	}

    //Method to withdraw cash
	public void withdraw(double cash)
	{
		if(balance>cash)
		{
			System.out.println("\n");
			balance=balance-cash;
			System.out.println("***You have Successfully withdraw your cash***");
			System.out.println("Your current balance is "+balance);
		}
		else
		{
			System.out.println("\n");
			System.out.println("You dont have enough balance..SORRY..");
		}
	}

	//Method for balance check
	public void balanceCheck()
	{
		System.out.println("\n");
		System.out.println("Account name    :"+acName);
		System.out.println("Account Number  : "+acNumber);
		System.out.println("Current Balance : "+balance);
	}
	
}
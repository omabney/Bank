//Bank Application

//Importing Scanner for reading values from user
import java.util.Scanner;
// import the ArrayList class
import java.util.ArrayList;

//Class for bank
public class Bank
{
    public String bankName;
	public String headquarters;
	public String parentOrganization;
    //Bank constructor  
    Bank(String bname, String hq, String pOrg)
	{
		bankName = bname;
        headquarters = hq;
        parentOrganization = pOrg;		
	}

    public static void main(String args[])
	{
        Scanner reader=new Scanner(System.in);
        //Initializing Bank class using constructor
        Bank b=new Bank("Bank of Utah","Ogden, Utah, United States","BOU Bancorp, Inc.");
        Admin admin = new Admin("Jacob", "Bank Manager", "jacob", "Jacob@123");
        ArrayList<Account> accounts = new ArrayList<Account>(); 
        int flag = 1;
        String pass;
		String user;
        do
		{
			//Main menu 
			System.out.println("\n\n\n");
			System.out.println("***Welcome to Bank of Utah***");
			System.out.println("1.View bank details");
			System.out.println("2.User login");
			System.out.println("3.Admin login");
			System.out.println("4.Exit");
			System.out.println("Enter your choice :- ");
            //Getting user input
			int choice = reader.nextInt();
			switch(choice)
			{
                case 1:
                    //option for displaying bank details
					b.Display();
					break;

				case 2:
                    //option for User login	
					System.out.println("\n");
					System.out.println("User Name :- ");
					user=reader.next();
					System.out.println("Password  :- ");
					pass=reader.next();
                    int index = -1;
                    //Validating username and password
                    for (int i = 0; i < accounts.size(); i++) {
                        if((accounts.get(i).check(user,pass))){
                            index = i;
                        }
                    }
                    if(index == -1){
                        System.out.println("Sorry!!. Invalid User Name and password.");
                        break;
                    }
                    
                    Account userAccount = accounts.get(index);
					if(userAccount.check(user,pass))
					{
						do
						{
							// User menu
							System.out.println("\n");
							System.out.println("***Welcome to Bank of Utah***");
							System.out.println("1.View Account details");
							System.out.println("2.Deposit");
							System.out.println("3.Withdraw");
							System.out.println("4.View Account Balance");
							System.out.println("5.Logout");
							System.out.println("Enter your choice :- ");
							choice = reader.nextInt();
							double csh;
							switch(choice)
							{
								case 1:
                                    System.out.println("\n");
                                    userAccount.display();
                                    break;
								case 2:
                                    System.out.println("\n");
                                    System.out.println("Enter the amount to deposit:- ");
                                    csh=reader.nextInt();
                                    userAccount.deposit(csh);
                                    break;
								case 3:
                                    System.out.println("\n");
                                    System.out.println("Enter the amount to withdraw:- ");
                                    csh=reader.nextDouble();
                                    userAccount.withdraw(csh);
                                    break;
								case 4:
                                    System.out.println("\n");
                                    userAccount.balanceCheck();
                                    break;
								case 5:
                                    flag=0;
                                    break;
								default:
                                    System.out.println("\n");
                                    System.out.println("You have entered Invalid choice.");
							}
				
						}while(flag == 1);
						flag=1;			
					}
					else
					{
						System.out.println("\n");
						System.out.println("Invalid User name or password");
					}
					break;
                	
				case 3:
                    //option for Admin login
					System.out.println("\n");
					System.out.println("Admin Name :- ");
					user=reader.next();
					System.out.println("Password  :- ");
					pass=reader.next();
					if(admin.check(user,pass))
					{
						do
						{
							System.out.println("\n");
							System.out.println("***Welcome to Bank of Utah***");
							System.out.println("1.View profile");
							System.out.println("2.Create Account");
							System.out.println("3.Remove Account");
							System.out.println("4.View all Account Details");
							System.out.println("5.Logout");
							System.out.println("Enter your choice :- ");
							choice = reader.nextInt();
							switch(choice)
							{
								case 1:
                                    System.out.println("\n");
                                    admin.display();
                                    break;
								case 2:
                                    //Creating New Account
                                    System.out.println("\n");
                                    String name,usName,usPin,acType,email;
                                    int acNumber;
                                    double deposit;
                                    System.out.println("***Create Account***");
                                    System.out.println("Enter Name :- ");
                                    name = reader.next();
                                    System.out.println("Enter Email :- ");
                                    email = reader.next();
                                    System.out.println("Enter username :- ");
                                    usName = reader.next();
                                    System.out.println("Enter pin number :- ");
                                    usPin = reader.next();
                                    System.out.println("Enter Account type :- ");
                                    acType = reader.next();
                                    System.out.println("Enter Initial Deposit :- ");
                                    deposit = reader.nextDouble();
                                    acNumber = accounts.size() + 1;
                                    Account account = new Account(name, acNumber, usName, usPin, acType, email, deposit);
                                    accounts.add(account);
                                    account.display();
                                    break;
								case 3:
                                    System.out.println("\n");
                                    System.out.println("***Delete Account***");
                                    System.out.println("List of all Accounts");
                                    //Display all accounts in the arrayList
                                    for (int i = 0; i < accounts.size(); i++) {
                                        accounts.get(i).display();
                                    }
                                    System.out.println("\nEnter the account number to be deleted:-");
                                    int ac = reader.nextInt();
                                    index = -1;
                                    //Finding the index of the given account number. 
                                    for (int i = 0; i < accounts.size(); i++) {
                                        if(accounts.get(i).getacNumber() == ac){
                                            index = i;
                                        }
                                    }
                                    //Removing the account object with given acNumber using remove function
                                    if(index != -1){
                                        accounts.remove(index);
                                        System.out.println("Account Number "+ac+" has successfully deleted.");
                                    }else{
                                        System.out.println("Sorry!!. Invalid account Number. ");
                                    }
                                    break;
								case 4:
                                    System.out.println("\n");
                                    System.out.println("***Current Accounts***");

                                    //Display all accounts in the arrayList
                                    for (int i = 0; i < accounts.size(); i++) {
                                        accounts.get(i).display();
                                    }
                                    break;
								case 5:
										flag=0;
										break;
								default:
										System.out.println("\n");
										System.out.println("You have entered Invalid choice.");
							}
						}while(flag == 1);
						flag=1;			
					}
					else
					{
						System.out.println("\n");
						System.out.println("Invalid User name or password");
					}
					break;
				case 4:
					flag=0;
					break;
				default:
					System.out.println("\n");
					System.out.println("You have entered Invalid choice.");
			}
		}while(flag==1);
	}
	//To Display all information of Bank
	public void Display()
	{
		System.out.println("\n");
		System.out.println("***Bank Details***");
		System.out.println("Bank Name : "+bankName);
		System.out.println("Headquarters: "+headquarters);
		System.out.println("Parent Organization: "+parentOrganization);
	}
}
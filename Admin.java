
//Admin Class
public class Admin implements User{
    private String adminName;
    private String adminPassword;
    private String adminPosition;
    private String usName;
    
    //Admin constructor
    Admin(String adName, String adPos, String usnm, String adPass){
        adminName = adName;
        adminPassword = adPass;
        adminPosition = adPos;
        usName = usnm;
    }

    //Method Definition for implemented class function Display
    public void display(){
        System.out.println("\n");
		System.out.println("***Admin Details***");
		System.out.println("Admin Name     :"+adminName);
		System.out.println("Admin Position : "+adminPosition);
        System.out.println("username     :"+usName);
		System.out.println("Password : "+adminPassword);
    }

    //Method Definition for implemented class function Check(Used to check username and password)
    public boolean check(String usName, String usPass){
        boolean b;
		if(adminPassword.equals(usPass)&&usName.equals(usName))
			b=true;
		else
			b=false;
		return b;
    }
} 
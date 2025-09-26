import java.util.*;
import java.lang.*;
import java.io.*;
class Account{
    public String name; //accessable to everywhere
    protected String email; // accessible to subclasses of other packages and accessible to current package everywhere
    private String password; // accessible to only class Account
    
    public void printInfo(){
        System.out.println("Name :"+ this.name);
        System.out.println("Email Id : "+ this.email);
        
    }
    //setters
    public void setPassword(String pass){
        this.password=pass;
        
    }
    //getters
    public String getPassword(){
        return this.password;
    }
}
class Bank
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Account account1 = new Account();
		account1.name ="Apana college";
		account1.email = "rajiitp102@gmail.com";
	//	account1.password = "abcd123";//give error 
		account1.setPassword("abcd123");
		account1.printInfo();
		System.out.println("Password is : "+account1.getPassword());

	}
}

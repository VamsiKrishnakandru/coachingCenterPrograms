/*
take input from user and compare to the email set we have and display appropriate message
O/P - 
Enter your email address: ravi@gmail.com
Welcome to home page
*/

import java.util.Scanner;

class ValidateEmail
{
  String[] emailset = {"ravi@gmail.com","nave@gmail.com","madi@gmail.com","gopi@gmail.com"};
  public void validate()
  {
    System.out.print("Enter your email address: ");
    Scanner scan = new Scanner(System.in);
    String email = scan.next();
    boolean found = false;
    for(int i=0; i<emailset.length; i++)
    {
      if(emailset[i].equalsIgnoreCase(email))
      {
        System.out.println("Welcome to home page");
        found = true;
        break;
      }
    }
    if(!found)
          System.out.println("Login failed");
  }
}

class Pro21
{
 public static void main(String[] args)
 {
   ValidateEmail ve = new ValidateEmail();
   ve.validate();
 }
}
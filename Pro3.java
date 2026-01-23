//When to use if and Switch blocks: 
//My understanding -> if block is used when we are dealing with true or false situation. 
//And switch block is used when a value can take multiple values and we need to make a decision based on what value is present.
//Interview Practical Answer -> "if" is used for authentication purpose where we need to decide whether to allow the user or not , 
//"switch" is used for searching and selection operations like web search. 

import java.util.Scanner;

class Pro3
{
  String name = "Ram";
  String url;
  String enteredName;
  public void takeInput()
  {
    System.out.println("Enter the url for the website: ");
    Scanner scan = new Scanner(System.in);
    url = scan.next();
    System.out.println("Enter the User Name: ");
    Scanner scan1 = new Scanner(System.in);
    enteredName = scan1.next();
    findApp();
  }

  public void display()
  {
    switch(url)
    {
      case "instagram": 
              getMessage("Instagram");
              break;
      case "gmail":
              getMessage("Gmail");
              break;
      case "fb":
              getMessage("FB");
              break;
      default: System.out.println("App not found");
    }
  }

  public void getMessage(String appName)
  {
    String msg="";
    if(enteredName.equalsIgnoreCase(name))
    {
      msg="Welcome to " + appName; 
    }
    else
    {
      msg="We cannot find you";
    }
    System.out.println(msg);
  }

  public void findApp()
  {
    url = url.toLowerCase();
    if(url.contains("instagram"))
    {
      url = "instagram";
    }
    else if(url.contains("gmail"))
    {
      url = "gmail";
    }
    else if(url.contains("fb"))
    {
      url = "fb";
    }
    else
    {
      url="NA";
    }
  }

  public static void main(String[] args)
  {
    Pro3 p = new Pro3();
    p.takeInput(); // scanner
    p.display(); 
  }
}




 


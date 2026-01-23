//Groceries, Cleaning, Stationary

import java.util.Scanner;


class SuperMarket
{
  int totalAmount;

  public void enterLocation()
  {
    String location="";
    Scanner scan = new Scanner(System.in);
    while(!location.equalsIgnoreCase("stop"))
    {
      System.out.println("Enter the location you are visiting");
      location = scan.next();
      location = location.toLowerCase();
      switch(location)
      {
        case "groceries": 
                    enterItem();
                    break;
        case "cleaning": 
                    enterItem();
                    break;
        case "stationary": 
                    enterItem();
                    break;
      }
    }
  }
  
  public void enterItem()
  {
    String name = "";
    int price = 0;
    Scanner scan = new Scanner(System.in);
    while(!name.equalsIgnoreCase("stop"))
    {
      System.out.println("Enter the Item you want to buy");
      name = scan.next();
      name = name.toLowerCase();
      switch(name)
      {
        case "apple": 
                price = 40;
                break;
        case "domex":
                price = 140;
                break;
        default: 
                price = 0;
      }
      totalAmount += price;
    }
  }

  public void printBill()
  {
    System.out.println("Total amount to be paid: " + totalAmount);
  }
}

class Pro4
{
  public static void main(String[] args)
  {
    SuperMarket sp = new SuperMarket();
    sp.enterLocation();
    sp.printBill();
  }
}
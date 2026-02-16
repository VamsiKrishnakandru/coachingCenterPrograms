/*
Find whether user entered number is even or odd without using modulus symbol.
O/P - 
Enter the number: 12
Entered number is even.
*/

import java.util.Scanner;

class EvenOrOdd
{
  public void find()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int num = scan.nextInt();
    int temp=(num*5)/10;
    if(temp*10==num*5)
        System.out.println("Entered number is even.");
    else
        System.out.println("Entered number is odd.");
  }
}


class Pro38
{
  public static void main(String[] args)
  {
     EvenOrOdd eo = new EvenOrOdd();
     eo.find();
  }
}

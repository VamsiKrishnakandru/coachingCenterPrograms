//Interview question
//Program where 2 numbers are added and multiplied without the use of + and *

import java.util.Scanner;

class SpeicalAdd
{
  public void addition()
  {
   Scanner scan = new Scanner(System.in);
   System.out.print("Enter the first no.: ");
   int a = scan.nextInt();
   System.out.print("Enter the second no.: ");
   int b = scan.nextInt();
   multiplication(a, b);
   for(int i=0; i<b; i++)
   {
     a++;
   }
   System.out.println("Addition Answer: " + a);
  }
   
  public void multiplication(int a, int b)
  {
   int k=a;
   for(int i=1; i<b; i++)
   {
     k=k+a;
   }
   System.out.println("Multiplication Answer: " + k);
  }
}

class Pro8
{
  public static void main(String[] args)
  {
    SpeicalAdd sa = new SpeicalAdd();
    sa.addition();
  } 
}
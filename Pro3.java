/*
print prime numbers less than specific number
O/P - 
Enter the number: 30
Prime numbers under given number are: 2 3 5 7 11 13 17 19 23 29
*/

import java.util.Scanner;

class PrimeNumbers
{
  public void findPrime()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int num = scan.nextInt();
    boolean isPrime = false;
    System.out.print("Prime numbers under given number are: ");
    for(int i=2; i<num; i++)
    {
      int k=0;
      for(int j=2; j<=i/2; j++)
      {
        if(i%j == 0)
        {
          k++;
        }
        if(k>0)
           break;
      }
      if(k==0)
            System.out.print(i + " ");
    }
  }
}

class Pro3
{
  public static void main(String[] args)
  {
     PrimeNumbers pm = new PrimeNumbers();
     pm.findPrime();
  }
}
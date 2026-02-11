/*
Take input from the user - 1st value - number of elements in an array and 2nd value - elements of the array
Count all the subarrays who sum is odd and display the total count.
I/P -
Enter the number of elements: 5
Enter the elements:
1 2 3 4 5
O/P-
Count for the odd sum: 9
*/

import java.util.Scanner;

class OddSum
{
  public void displayCount()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int len = scan.nextInt();
    System.out.println("Enter the elements: ");
    int[] ar = new int[len];
    for(int i=0; i<len; i++)
        ar[i] = scan.nextInt();
    int count = 0;
    for(int i=0; i<len; i++)
    {
      for(int j=i; j<len; j++)
      {
         int sum = 0;
         for(int k=j; k>=i; k--)
            sum += ar[k];
         if(sum%2 == 1)
              count++;
      }
    }
    System.out.println("Count for the odd sum: " + count);
  }
}

class Pro34
{
  public static void main(String[] args)
  {
    OddSum os = new  OddSum();
    os.displayCount();
  }
}
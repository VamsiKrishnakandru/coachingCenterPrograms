/*
One dimension array problem - add digits in array or arrage them in ascending and descending order
O/P - 
Enter from following operations: sum, asc, desc: sum
Enter 5 numbers:
2
3
4
1
6
Sum of the digits: 16

Enter from following operations: sum, asc, desc: asc
Enter 5 numbers:
2
3
4
1
5
Ascending order of digits:
12345

Enter 5 numbers:
2
3
4
1
5
Descending order of digits:
54321
*/

import java.util.Scanner;

class OneDimensionArray
{
  public void operation()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter from following operations: sum, asc, desc: ");
    String op = scan.next();
    op = op.toLowerCase();
    System.out.println("Enter 5 numbers:");
    int[] narray = new int[5];
    for(int i = 0; i<5; i++)
    {
       narray[i] = scan.nextInt();
    }
    switch(op)
    {
      case "sum": 
             addDigits(narray);
             break;
      case "asc":
             ascendingOrder(narray, true);
             break;
      case "desc":
             descendingOrder(narray);
             break;
      default:
             System.out.println("Operation not found.");
    }
  }
  
  public void addDigits(int[] narray)
  {
    int len = narray.length, sum = 0;
    for(int i=0; i<len; i++)
    {
      sum += narray[i];
    }
    System.out.println("Sum of the digits: " + sum);
  }
  
  public int[] ascendingOrder(int[] narray, boolean print)
  {
    int len = narray.length;
    for(int i=0; i<len; i++)
    {
      for(int j=0; j<len-i-1; j++)
      {
        if(narray[j] > narray[j+1])
        {
          int temp = narray[j];
          narray[j] = narray[j+1];
          narray[j+1] = temp;
        }
      }
    }
    if(print)
    {
      System.out.println("Ascending order of digits: ");
      for(int i=0; i<5; i++)
      {
         System.out.print(narray[i]);
      }
    }
    return narray;
  }
  
  public void descendingOrder(int[] narray)
  {
    int[] temp = ascendingOrder(narray, false);
    System.out.println("Descending order of digits: ");
    for(int i=4; i>=0; i--)
    {
       System.out.print(narray[i]);
    }
  }
}

class Pro15
{
  public static void main(String[] args)
  {
    OneDimensionArray od = new OneDimensionArray();
    od.operation();
  }
}
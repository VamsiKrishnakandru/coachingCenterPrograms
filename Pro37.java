/*
For the given set of numbers perform bubble sort and find the user entered number using linear and binary search.
ar = {4,3,2,5,2,1,7,9,8};
O/P - 
Enter the number to search: 4
Sorted array: 1 2 3 4 5 6 7 8 9
Found at index by linear search: 3
Found at index by binary search: 3
*/

import java.util.Scanner;


class FindNum
{
  int[] ar = {4,3,2,5,6,1,7,9,8};
  public void performSortAndFind()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number to search: ");
    int num = scan.nextInt();
    for(int i=0; i<ar.length; i++)
    {
      for(int j=0; j<ar.length-i-1; j++)
      {
        if(ar[j] > ar[j+1])
        {
          int temp= ar[j];
          ar[j] = ar[j+1];
          ar[j+1] = temp;
        }
      }
    }
    System.out.print("Sorted array: ");
    for(int i=0; i<ar.length; i++)
    {
      System.out.print(ar[i] + " ");
    }
    System.out.println();
    boolean isfound = false;
    for(int i=0; i<ar.length; i++)
      if(num==ar[i])
      {
         System.out.println("Found at index by linear search: " + i);
         isfound=true;
         break;
      }
    if(!isfound)
      System.out.println("Not found using linear search"); 
    int l=0, r=ar.length-1, m=0;
    while(l<=r)
    {
      m=(l+r)/2;
      if(ar[m]==num)
      {
        System.out.println("Found at index by binary search: " + m);
        break;
      }
      else if(num<ar[m])
      {
        r=m-1;
      }
      else if(num>ar[m])
      {
        l=m+1;
      }
    }
    if(l>r)
       System.out.println("Not found using binary search");   
  }
}

class Pro37
{
  public static void main(String[] args)
  {
    FindNum fn = new FindNum();
    fn.performSortAndFind();
  }
}
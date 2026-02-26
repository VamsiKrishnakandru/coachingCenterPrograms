/*
For the given set of numbers perform quick sort and find the user entered number using linear and binary search.
ar = {7,3,2,5,1,6,4,9,8};
O/P - 
Enter the number to search: 4
Sorted array: 1 2 3 4 5 6 7 9 8
Found at index by linear search: 3
Found at index by binary search: 3
*/

import java.util.Scanner;


class FindNum
{
  int steps = 0;
  int[] ar = {7,3,2,5,1,6,4,9,8};
  public void performSortAndFind()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number to search: ");
    int num = scan.nextInt();
    performQuickSort(0, ar.length-1);
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

  public void performQuickSort(int l, int r)
  {
    int[] temp = new int[ar.length];
    if(l==r || r<0 || l<0 || l>r)
       return;
    int pivot = (l+r)/2;
    for(int i=0; i<l; i++)
    {
      temp[i] = ar[i];
    }
    int j=l;
    for(int i=l; i<=r; i++)
    {
      if(ar[i] < ar[pivot])
      {
         temp[j] = ar[i];
         j++;
      }
    }
    int newp = j;
    temp[j] = ar[pivot];
    j++;
    for(int i=l; i<=r; i++)
    {
      if(ar[i] > ar[pivot])
      {
         temp[j] = ar[i];
         j++;
      }
    }
    for(int i=(r+1); i<ar.length; i++)
    {
      temp[i] = ar[i];
    }
    for(int i=0; i<ar.length; i++)
        ar[i] = temp[i];
    performQuickSort(l, newp-1);
    performQuickSort(newp+1, r);
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
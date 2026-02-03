/*Binary Search
o/p -
Enter the number to search: 40
Found at index: 2
Enter the number to search: 3
Number is not present in the array
*/

import java.util.Scanner;

class Pro2 
{
  
  public static void main(String[] args)
  {
    BinarySearch bs = new BinarySearch();
    bs.startSearch();
  }
}

class BinarySearch
{
  public void startSearch()
  {
    int[] array = {10, 20, 40, 50};
    int length = array.length;
    int middle = length/2;
    int left = 0;
    int right = length-1;
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the number to search: ");
    int search = scan.nextInt();
    while(right>=left)
    {
      middle = (left+right)/2;
      if(search==array[middle])
      {
         System.out.println("Found at index: " + middle); 
         return;
      }
      else if(search>array[middle])
      {
        left = middle+1;
      }
      else
      {
        right = middle-1;
      }
    }
    System.out.println("Number is not present in the array");
  }
}
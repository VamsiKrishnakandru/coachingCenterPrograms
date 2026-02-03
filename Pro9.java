/*Selection Sort
O/P - 
Before sorting: [ 3, 5, 2, 6, 4, 7, 20, 8, 1, 9, 10, ]
After sorting: [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, ]
*/

class BubbleSort
{
  int[] ar = {3,5,2,6,4,7,20,8,1,9,10};
 
  public void performSort()
  {
    int l = ar.length;
    System.out.print("Before sorting: [ ");
    for(int i=0; i<l; i++)
    {
      System.out.print(ar[i] + ", ");
    }
    System.out.println("]");
    for(int i=0; i<l; i++)
    {
      for(int j=0; j<l-i-1; j++)
      {
        if(ar[j]>ar[j+1])
        {
          int temp = ar[j];
          ar[j] = ar[j+1];
          ar[j+1] = temp;
        }
      }
    }
    System.out.print("After sorting: [ ");
    for(int i=0; i<l; i++)
    {
      System.out.print(ar[i] + ", ");
    }
    System.out.println("]");
  }
}

class Pro9
{
  public static void main(String[] args)
  {
    BubbleSort bs = new BubbleSort();
    bs.performSort();
  }
}
//Selection Sort
//Before sorting: [ 3, 5, 2, 6, 4, 7, 20, 8, 1, 9, 10, ]
//After sorting: [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, ]

class SelectionSort
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
    for(int i=0; i<l-1; i++)
    {
      int s = ar[0], k=0;
      for(int j=1; j<l-i; j++)
      {
        if(s<ar[j])
        {
          s = ar[j];
          k = j;
        }
      }
      int temp = ar[k];
      ar[k] = ar[l-i-1];
      ar[l-i-1] = temp;
    }
    System.out.print("After sorting: [ ");
    for(int i=0; i<l; i++)
    {
      System.out.print(ar[i] + ", ");
    }
    System.out.println("]");
  }
}

class Pro10
{
  public static void main(String[] args)
  {
    SelectionSort bs = new SelectionSort();
    bs.performSort();
  }
}
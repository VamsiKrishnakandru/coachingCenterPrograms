//Q1)
//===
//  int a[]={4,7,9};

class MissingNum
{
  int[] ar = {1,2,5,6,7,9};

  public void findMissing()
  {
    int len = ar.length;
    int start = ar[0];
    System.out.println("Given array: ");
    for(int i=0; i<len; i++)
    {
      System.out.print(ar[i] + " ");
    }
    System.out.println();
    System.out.println("Missing numbers: ");
    for(int i=0; i<len; i++)
    {
      if(start != ar[i])
      {
        System.out.print(start + " ");
        i--;
      }
      start++;
    }
  }
}


class Pro19
{
  public static void main(String[] args)
  {
    MissingNum mn = new MissingNum();
    mn.findMissing();
  }
}

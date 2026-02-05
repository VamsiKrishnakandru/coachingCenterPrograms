/*
merge k sorted arrays in ascending order.
I/P - 
{{1,4,5},{1,3,4},{2,6}}
O/P -
1 1 2 3 4 4 5 6
*/


class MergeArrays
{
  int[][] sa = {{1,4,5},{1,3,4},{2,6}};
  public void mergesa()
  {
    int len = 0;
    for(int i=0; i<sa.length; i++)
    {
      for(int j=0; j<sa[i].length; j++)
      {
        len++;
      }
    }
    int[] temp = new int[len];
    int z = 0;
    for(int k=0; k<sa.length; k++)
    {
      for(int l=0; l<sa[k].length; l++)
      {
        temp[z] = sa[k][l];
        z++;
      }
    }
    for(int i=0; i<len; i++)
    {
      for(int j=0; j<len-i-1; j++)
      {
        if(temp[j] > temp[j+1])
        {
          int temp1 = temp[j];
          temp[j] = temp[j+1];
          temp[j+1] = temp1;
        }
      }
    }
    for(int i=0; i<len; i++)
    {
      System.out.print(temp[i] + " ");
    }
  }
}

class Pro27
{
  public static void main(String[] args)
  {
    MergeArrays ma = new MergeArrays();
    ma.mergesa();
  }
}
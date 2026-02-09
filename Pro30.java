/* 
Find the values for missing block and solve the sudoku
i/p - 
5 1 7 6 9 8 2 3 4
2 8 9 1 3 4 7 5 6
3 4 6 2 5 7 8 9 1
6 7 2 8 4 9 3 1 5
1 3 8 5 2 6 9 4 7
9 5 4 7 1 3 6 0 2
0 0 0 9 6 1 5 7 8
0 0 0 4 8 5 3 2 6
0 0 0 3 7 2 4 1 0

o/p - 
5 1 7 6 9 8 2 3 4
2 8 9 1 3 4 7 5 6
3 4 6 2 5 7 8 9 1
6 7 2 8 4 9 3 1 5
1 3 8 5 2 6 9 4 7
9 5 4 7 1 3 6 8 2
4 2 3 9 6 1 5 7 8
7 9 1 4 8 5 3 2 6
8 6 5 3 7 2 4 1 9
*/

class FindMissing
{
  int[][] s = {
     {5,1,7,6,9,8,2,3,4},
     {2,8,9,1,3,4,7,5,6},
     {3,4,6,2,5,7,8,9,1},
     {6,7,2,8,4,9,3,1,5},
     {1,3,8,5,2,6,9,4,7},
     {9,5,4,7,1,3,6,0,2},
     {0,0,0,9,6,1,5,7,8},
     {0,0,0,4,8,5,3,2,6},
     {0,0,0,3,7,2,4,1,0}
  };
    
  public void find()
  {
    System.out.println("Before: ");
    printSudoku();

    int a=0, b=0;
    boolean found=false;
    for(int i=0; i<9; i++)
    {
      for(int j=0; j<9; j++)
      {
        if(s[i][j] == 0 && i<7 && j<7)
        {
          a=i;
          b=j;
          found=true;
          break;
        }
      }
      if(found)
          break;
    }
    for(int i=a; i<a+3; i++)
    {
      for(int j=b; j<b+3; j++)
      {
        findandreplace(i, j);
      }
    }  
    for(int i=0; i<9; i++)
    {
      for(int j=0; j<9; j++)
      {
        if(s[i][j] == 0)
        {
           findandreplace(i,j);
        }
      }
    }
  
    System.out.println("After: ");
    printSudoku();
  }
 
  public void findandreplace(int i, int j)
  {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int k=0;
        while(k<9)
        {
          for(int m=0; m<9;m++)
                 {
                   if(nums[m] == s[i][k])
                   {
                     nums[m] = 0;
                   }
                 }
           k++;
        }
        k=0;
        while(k<9)
        {
          for(int m=0; m<9;m++)
                 {
                   if(nums[m] == s[k][j])
                   {
                     nums[m] = 0;
                   }
                 }
           k++;
        }
        k=0;
        for(int t=0; t<9; t++)
        {
          if(nums[t] != 0)
             k++;
        }
        if(k==1)
        {
          for(int t=0; t<9; t++)
          {
             if(nums[t] != 0)
             {
                 s[i][j] = nums[t];
                 break;
             }
          }
        }
  }

  public void printSudoku()
  {
    for(int i=0; i<9; i++)
    {
      for(int j=0; j<9; j++)
          System.out.print(s[i][j] + " ");
      System.out.println();
    }
    System.out.println();
  }
}

class Pro30
{
  public static void main(String[] args)
  {
     FindMissing fm = new FindMissing();
     fm.find();
  }
}


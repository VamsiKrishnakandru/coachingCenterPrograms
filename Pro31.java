/* 
Solve the sudoku using back tracking 
i/p - 
0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0

o/p - 
1 4 5 3 2 7 6 9 8
8 3 9 6 5 4 1 2 7
6 7 2 9 1 8 5 4 3
4 9 6 1 8 5 3 7 2
2 1 8 4 7 3 9 5 6
7 5 3 2 9 6 4 8 1
3 6 7 5 4 2 8 1 9
9 8 4 7 6 1 2 3 5
5 2 1 8 3 9 7 6 4
*/

class SolveSudoku
{
  int[][] b = {
            {3,0,0,0,4,9,0,0,0},
            {0,0,0,6,0,0,5,0,1},
            {7,5,2,0,0,1,0,0,0},
            {0,0,1,0,0,0,7,0,0},
            {5,0,0,3,9,6,0,0,0},
            {0,0,8,1,5,0,0,9,6},
            {0,0,3,0,1,0,0,6,0},
            {0,0,4,0,0,0,1,0,0},
            {0,0,0,0,2,8,0,0,0}
  };
 
  int[][] temp;
   
    
  public void solve()
  {
    System.out.println("Before: ");
    printSudoku();

    int count = 0;    
    for(int i=0; i<9; i++)
       for(int j=0; j<9; j++)
              if(b[i][j] == 0)
                  count++;

    temp = new int[count][9];
    int t=0;
    for(int i=0; i<9; i++)
       for(int j=0; j<9; j++)
              if(b[i][j] == 0)
              {
                temp[t] = findnums(i, j);
                t++;
              }
    
    for(int i=0; i<count; i++)
    {   
      for(int j=0; j<count-i-1; j++)
      {
        if(temp[j][11] > temp[j+1][11])
        {
           int[] temp1 = new int[12];
           for(int k=0; k<12; k++)
              temp1[k] = temp[j][k];
           for(int k=0; k<12; k++)
              temp[j][k] = temp[j+1][k];
           for(int k=0; k<12; k++)
              temp[j+1][k] = temp1[k];
        }
      }
    }
     
    fill(temp[0]);
   
    System.out.println("After: ");
    printSudoku();
  }
 
  public boolean fill(int[] temp1)
  {
     int i = temp1[9];
     int j = temp1[10];
    
     boolean isfull = true;
     for(int k=0; k<9; k++)
        for(int l=0; l<9; l++)
            if(b[k][l] == 0)
               isfull = false;
     
     if(isfull)
         return true;

     for(int k=0; k<9; k++)
        if(temp1[k] != 0)
        {
          b[i][j] = temp1[k];
          int t=0;
          for(int u=0; u<9; u++)
            for(int v=0; v<9; v++)
              if(b[u][v] == 0)
              {
                temp[t] = findnums(u, v);
                t++;
              }
          int[][] temp2 = new int[25][12];
          for(int p=0; p<25; p++)
             for(int q=0; q<12; q++)
                  temp2[p][q] = temp[p][q];
          boolean isdone = fill(temp[0]);
          for(int p=0; p<25; p++)
             for(int q=0; q<12; q++)
                  temp[p][q] = temp2[p][q];
          if(isdone) 
               return true;
          b[i][j] = 0;
        }
     return false;
  }
 
  public int[] findnums(int i, int j)
  {
     int[] nums = {1,2,3,4,5,6,7,8,9,0,0,0};
     for(int k=0; k<9; k++)
        for(int m=0; m<9; m++)
           if(b[i][k] == nums[m])
                  nums[m] = 0;
     for(int k=0; k<9; k++)
        for(int m=0; m<9; m++)
           if(b[k][j] == nums[m])
                  nums[m] = 0;
     int l1 = i - i%3;
     int l2 = j - j%3;
     for(int k=l1; k<l1+3; k++)
     {
       for(int l=l2; l<l2+3; l++)
       {
          for(int m=0; m<9; m++)
          {
            if(b[k][l] == nums[m])
                  nums[m] = 0;
          }
       }
     }
     nums[9] = i;
     nums[10] = j;
     int count = 0;
     for(int k=0; k<9; k++)
        if(nums[k] != 0)
           count++;
     nums[11] = count;
     return nums;
  }

  public void printSudoku()
  {
    for(int i=0; i<9; i++)
    {
      for(int j=0; j<9; j++)
          System.out.print(b[i][j] + " ");
      System.out.println();
    }
    System.out.println();
  }
}

class Pro31
{
  public static void main(String[] args)
  {
     SolveSudoku ss = new SolveSudoku();
     ss.solve();
  }
}


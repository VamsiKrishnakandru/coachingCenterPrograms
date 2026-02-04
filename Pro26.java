/*
complete a incomplete sudoku
Given Sudoku:
5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9

Solved Sudoku:
5 3 4 6 7 8 9 1 2
6 7 2 1 9 5 3 4 8
1 9 8 3 4 2 5 6 7
8 5 9 7 6 1 4 2 3
4 2 6 8 5 3 7 9 1
7 1 3 9 2 4 8 5 6
9 6 1 5 3 7 2 8 4
2 8 7 4 1 9 6 3 5
3 4 5 2 8 6 1 7 9
*/ 

class Sudoku
{
  int[][] s = {{5,3,0,0,7,0,0,0,0},{6,0,0,1,9,5,0,0,0},{0,9,8,0,0,0,0,6,0},{8,0,0,0,6,0,0,0,3},
               {4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},
               {0,0,0,0,8,0,0,7,9}};

  public void fill()
  {
    System.out.println("Given Sudoku: ");
    print();
    int it = 1;
    while(it > 0)
    {
    it=0; 
    int k=0;
    while(k<9)
    {
      int l=0;
      while(l<9)
      {
        int[] temp1 = {1,2,3,4,5,6,7,8,9};
        int[][] temp2 = new int[9][2];
        int d = 0;
        for(int i=k; i<k+3; i++)
        {
          for(int j=l; j<l+3; j++)
          {
             for(int u=0; u<9; u++)
             {
               if(temp1[u] == s[i][j])
                           temp1[u] = 0;
             }  
             if(s[i][j] == 0)
             {
               temp2[d][0] = i;
               temp2[d][1] = j;
               d++;
             }
          }
        }
        l=l+3;
        findnums(temp1, temp2);
      }
      k=k+3;
    }
    for(int i=0; i<9; i++)
    {
      for(int j=0; j<9; j++)
      {
        if(s[i][j] == 0)
        {
          it++;
        }
      }
    }
    }
    System.out.println("Solved Sudoku: ");
    print();
  }

  public void findnums(int[] temp1, int[][] temp2)
  {
    int[] notmatch = new int[9];
    /*for(int i=0; i<9; i++)
    {
      if(temp1[i] != 0)
      {
        System.out.print(temp1[i]);
      }
    }
    System.out.println();*/
    for(int i=0; i<9; i++)
    {
      if(!(temp2[i][0] == 0 && temp2[i][1] ==0))
      {
        for(int m1=0; m1<9; m1++)
        {  
           if(temp1[m1] != 0) 
                  notmatch[m1] += findprob(temp2[i][0], temp2[i][1], temp1[m1], true);
        }
      }
    }
    for(int j=1; j<10; j++)
    {
      if(notmatch[j-1] == 1)
      {
        for(int i=0; i<9; i++)
        {
          if(!(temp2[i][0] == 0 && temp2[i][1] ==0))
          {
            findprob(temp2[i][0], temp2[i][1], j, false);
          }
        }
      } 
    }
  }
  
  public int findprob(int a, int b, int temp1, boolean find)
  {
    boolean notmatch = true;
    for(int i=0; i<9; i++)
    {  
      if(s[a][i] == temp1)
      {
        notmatch = false;
        break;
      }
    }
    for(int i=0; i<9; i++)
    { 
      if(s[i][b] == temp1)
      {
        notmatch = false;
        break;
      }
    }
    if(find)
    {
      if(notmatch)
      {
         return 1;
         //System.out.println(a +" - "+ b +" - "+ temp1 +" - "+ notmatch); 
      }
      return 0;
    }
    else
    {
      if(notmatch)
      {
        s[a][b] = temp1;
      }
    }
    return 0;
  }

  public void print()
  {
    for(int i=0; i<9; i++)
    {
      for(int j=0; j<9; j++)
      {
        System.out.print(s[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

class Pro26
{
  public static void main(String args[])
  {
    Sudoku s = new Sudoku();
    s.fill();
  }
}
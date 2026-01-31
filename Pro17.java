//Matrix multiplication in 3-d integer array and displaying different combinations of striaght lines possible in 3x3 matrix

import java.util.Scanner;

class ThreeDimArray
{
  public void operate()
  {
    int[][][] tdarray = takeInput();
    int[][] mul = matrixmul(tdarray);
    System.out.println("3-d Array: ");
    display3d(tdarray);
    System.out.println("matrix mul of 1st and 2nd matrix: ");
    display2d(mul, true);
    int[][] comb = printComb(mul);
    System.out.println("different combination of straight lines in matrix: ");
    display2d(comb, false);
  }
  
  public int[][] matrixmul(int[][][] temp)
  {
    int[][] mul = new int[3][3];
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        for(int k=0; k<3; k++)
        {
          mul[i][j] += temp[0][i][k] * temp[1][k][j];
        }
      }
    }
    return mul;
  }

  public int[][][] takeInput()
  {
    int[][][] temp = new int[3][3][3];
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the elements for 3d matrix: ");
    for(int k=0; k<3; k++)
    {
      for(int i=0; i<3; i++)
      {
        for(int j=0; j<3; j++)
        {
          temp[k][i][j] = scan.nextInt();
        }
      }
    }
    return temp;
  }

  public int[][] printComb(int[][] temp1)
  {
    int[][] comb = new int[8][3];
    for(int i=0; i<8; i++)
    {
      if(i<3)
      {
        for(int j=0; j<3; j++)
        {
          comb[i][j] = temp1[i][j]; 
        }
      }
      else if(i>2 && i<6)
      {
        for(int t=0; t<3; t++)
        {
            comb[i][t] = temp1[t][i-3];
        }
      }
      else if(i==6)
      {
        for(int t=0; t<3; t++)
        {
          comb[i][t] = temp1[t][t];   
        }
      }
      else
      {
        int t = 0, j=2;
        while(t<3 && j>=0)
        {
           comb[i][t] = temp1[t][j]; 
           t++;
           j--;
        }
      }
    }
    return comb;
  }
 
  public void display3d(int[][][] temp)
  {
    for(int k=0; k<3; k++)
    {
      for(int i=0; i<3; i++)
      {
        for(int j=0; j<3; j++)
        {
          System.out.print(temp[k][i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }
  
  public void display2d(int[][] temp, boolean issqmat)
  {
    int len = issqmat ? 3 : 8;
    for(int i=0; i<len; i++)
    {
      for(int j=0; j<3; j++)
      {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }
  }
}

class Pro17
{
  public static void main(String[] args)
  {
    ThreeDimArray td = new ThreeDimArray();
    td.operate();
  }
}
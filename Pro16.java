/*
Do operations on 3x3 matrices - adding the elements, multiplying the elements
From the added matrix find all permutations formed when forming a straight line of three elements across matrix
O/P -
Matrix a:
1 2 2
3 2 1
2 3 2
Matrix b:
2 3 1
2 3 2
3 2 1
Sum of Matrix a and b:
3 5 3
5 5 3
5 5 3
Matrix multiplication of a and b:
12 13 7
13 17 8
16 19 10
different combination of straight lines in matrix:
3 5 3
5 5 3
5 5 3
3 5 5
5 5 5
3 3 3
3 5 3
3 5 5
*/

import java.util.Scanner;

class TwoDimensionArray
{
  public void operate()
  {
    int[][] a = input("first");
    int[][] b = input("second");
    int[][] sum = new int[3][3];
    int[][] mul = new int[3][3];
    int[][] comb = new int[8][3];
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        sum[i][j] = a[i][j] + b[i][j];
      }
    }
    mul = matrixMul(a, b);
    comb = printComb(sum);
    System.out.println("Matrix a: ");
    display(a, true);
    System.out.println("Matrix b: ");
    display(b, true);
    System.out.println("Sum of Matrix a and b: ");
    display(sum, true);
    System.out.println("Matrix multiplication of a and b: ");
    display(mul, true);
    System.out.println("different combination of straight lines in matrix: ");
    display(comb, false);
  }

  public int[][] matrixMul(int[][] temp1, int[][] temp2)
  {
    int[][] mul = new int[3][3];
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        for(int k=0; k<3; k++)
        {
          mul[i][j] += temp1[i][k] * temp2[k][j]; 
        }
      }
    }
    return mul;
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

  public int[][] input(String s)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the " + s + " matrix: ");
    int[][] temp = new int[3][3];
    for(int i=0; i<3; i++)
    {
      for(int j=0; j<3; j++)
      {
        temp[i][j] = scan.nextInt();
      }
    }
    return temp;
  }
  
  public void display(int[][] temp, boolean issqmat)
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

class Pro16
{
  public static void main(String[] args)
  {
    TwoDimensionArray td = new TwoDimensionArray();
    td.operate();
  }
}
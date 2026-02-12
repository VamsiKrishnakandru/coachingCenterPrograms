/* Pattern problems
    *
  *   *
* * * * *
*       *
*       *

* * * *
*       *
* * * * *
*       *
* * * *

  * * * *
*
*
*
  * * * *

* * * *
*       *
*       *
*       *
* * * *

* * * * *
*
* * * * *
*
* * * * *

* * * * *
*
* * * * *
*
*

  * * *
*
*   * * *
*       *
  * * *

*       *
*       *
* * * * *
*       *
*       *
*/


class PrintAlpha
{
  public void print()
  {
    int k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(i==2 && j<=3 && j>=1)
        {
          System.out.print("* ");
        }
        else if(j-k==2 || j+k==2)
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(i==2 && j<=3 && j>=1)
        {
          System.out.print("* ");
        }
        else if((i==0 || i==4) && j<=3)
        {
          System.out.print("* ");
        }
        else if((j==0 || j==4) && i>=1 && i<=3)
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(j==0 && i<=3 && i>=1)
        {
          System.out.print("* ");
        }
        else if((i==0 || i==4) && j>0 && j<5)
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(j==0)
        {
          System.out.print("* ");
        }
        else if(j==4 && i<=3 && i>=1)
        {
          System.out.print("* ");
        }
        else if((i==0 || i==4) && j>0 && j<4)
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(j==0)
        {
          System.out.print("* ");
        }
        else if((i==0 || i==4 || i==2) && j>0 && j<5)
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(j==0)
        {
          System.out.print("* ");
        }
        else if((i==0 || i==2) && j>0 && j<5)
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if((j==0 && i>0 && i<4) || (j==4 && i>1 && i<4))
        {
          System.out.print("* ");
        }
        else if((i==0  && j>0 && j<4) || (i==4 && j>0 && j<4) || (i==2 && j>1 && j<5) )
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
    System.out.println();
    k=0;
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if((i==2 && j>0 && j<4))
        {
          System.out.print("* ");
        }
        else if((j==0 || j==4))
        {
          System.out.print("* ");
        }
        else
          System.out.print("  ");
      }
      System.out.println();
      if(k<2)
         k++;
    }
  }
}

class Pro36
{
  public static void main(String[] args)
  {
    PrintAlpha pa = new PrintAlpha();
    pa.print();
  }
}
//program to generate below pattern
//H    H    H    H    H
//H    VS   H    H    H
//H    H    VS   H    H
//H    H    H    VS   H
//H    H    H    H    H

class Pattern
{
  public void printPattern1()
  {
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        if(i==j && i<=3 && i>=1 && j<=3 && j>=1)
        {
          System.out.print("  VS ");
        }
        else
        {
          System.out.print("  H  ");
        }
      }
      System.out.println();
    }
  }

  public void printPattern2()
  {
    int i = 0; 
    while(i<5)
    {
      switch(i)
      {
        case 1: 
             System.out.println(" H " + " VS" + " H  H  H ");
             break;
        case 2: 
             System.out.println(" H  H " + " VS" + " H  H ");
             break;
        case 3: 
             System.out.println(" H  H  H " + " VS" + " H ");
             break;
        default:
             System.out.println(" H  H  H  H  H ");   
      }
      i++;         
    }
  }

 public void printPattern3()
  {
    for(int i=3; i<14; i=i+2)
    {
      for(int j=3; j<14; j=j+2)
      {
        switch(i*j)
        {
          case 25, 49, 81, 121: 
                System.out.print("  VS ");
                break;
          default:
                System.out.print("  H  ");
        }
      }
      System.out.println();
    }
  }
}
class Pro5
{
  public static void main(String[] args)
  {
    Pattern p = new Pattern();
    p.printPattern1();
    p.printPattern2();
    p.printPattern3();
  }
}
/*
program to take values from the user and find lowest, highest, middle and repeat digits in the user entered number
Enter a number: 832489234
4 - 2
3 - 2
2 - 2
9 - 1
8 - 2
Lowest digit: 2
Higest digit: 9
middle digit: 8
*/


import java.util.Scanner;

class Digits
{
  int lowest = 9, highest, middle1, middle2;
  public void findDigits()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = scan.nextInt();
    int len = 0, k = num, z=num;
    System.out.println("Digit - number of times it appeared");
    while(k > 0)
    {
      len++;
      k = k/10;
    }
    k=0;
    while(num!=0)
    {
      int l = (num/10) * 10;
      l = (num/10 != 0) ? num%l : num;
      findLowest(l);
      findHighest(l);
      if(k == len/2)
      {
        middle1=l;
      }
      else if(k == len/2-1)
      {
        middle2=l;
      }
      k++;
      num=num/10;
      findRepeat(l, num, len-k, z, len);
    }
    System.out.println("Lowest digit: "+ lowest);
    System.out.println("Higest digit: "+ highest);
    if(len%2!=0)
    {
      System.out.println("middle digit: "+ middle1);
    }
    else
    {
      System.out.println("middle digits: " + middle1 + ", " + middle2);
    }
  }

  private void findLowest(int num)
  {
    if(lowest>num)
    {
      lowest = num;
    }
  }
  
  private void findHighest(int num)
  {
    if(highest<num)
    {
      highest = num;
    }
  }

  private void findRepeat(int a, int num, int len, int z, int l)
  {
    int v=1, u=num;
    int x=power10(l-len+1);
    int p = num==0 ? z : z%(num*x);
    while(p>10)
    {
      int y = (p/10) * 10;
      y = (p/10 != 0) ? p%y : p;
      p=p/10;
      if(y==a)
      {
        return;
      }
    }
    while(len>=1)
    {
      int w = power10(len);
      if(num/w == a)
      {
        v++;
      }
      num=num%w;
      len--;
    }
    System.out.println(a + " - " + v);
  }
  
  private int power10(int p)
  {
    if(p==1)
    {
      return 1;
    }  
    return 10 * power10(--p);
  }
}

class Pro7
{
  public static void main(String[] args)
  {
    Digits d = new Digits();
    d.findDigits();
  }
}
//Amstrong Numbers between 1 and 50000
//ABC…N = A^n + B^n + C^n + … + N^n
//1 2 3 4 5 6 7 8 9 153 370 371 407 1634 8208 9474

class AmstrongNum
{
  public void printNum()
  {
    int num = 50000;
    for(int i=1; i<num; i++)
    {
      int cp = i, l=1, t=0;
      while(cp>10)
      {
        l++;
        cp = cp/10;
      }
      cp = i;
      while(cp!=0)
      {
        int y = cp%10;
        t = t + powerFun(y,l);
        cp = cp/10;
      }
      if(t==i)
      {
        System.out.print(i + " ");
      }
    }
  }
  
  public int powerFun(int a, int b)
  {
    int k=1;
    for(int i = 0; i < b; i++)
    {
      k=k*a;
    }
    return k;
  }
}

class Pro12
{
  public static void main(String[] args)
  {
    AmstrongNum am = new AmstrongNum();
    am.printNum();
  }
}


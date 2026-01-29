//
import java.util.Scanner;

class ArrayManipulation
{
  public void operateOnArray()
  {
    Scanner scan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    System.out.println("Available operations are: ccount, aorder, wswap, rcommon");
    System.out.print("Enter the operation: ");
    String op = scan.next();
    System.out.print("Enter the stentence: ");
    String s = scan1.nextLine();
    switch(op)
    {
      case "ccount":
           duplicatecharcount(s);
           break;
      case "aorder":
           alphabeticorder(s);
           break;
      case "wswap":
           wordswap(s);
           break;
      case "rcommon":
           removecommon(s);
           break;
      default:
           System.out.println("Invalid operation");
    }
  }
  
  public void duplicatecharcount(String s)
  {
    s = s.toLowerCase();
    char[] ch = s.toCharArray();
    int len = ch.length;
    int[] count = splitandarrange(ch);
    for(int i=0; i<len; i++)
    {
       if(count[i] > 1 && ch[i] != ' ')
                System.out.println(ch[i] + "-" + count[i]);
    }
  }
  

  public void alphabeticorder(String s)
  {
    s = s.toLowerCase();
    char[] ch = s.toCharArray();
    int len = ch.length;
    int[] count = splitandarrange(ch);
    for(int i=0; i<len; i++)
    {
      for(int k=0; k<len-i-1; k++)
      {
         if(ch[k] > ch[k+1])
         {
           char temp = ch[k+1];
           ch[k+1] = ch[k];
           ch[k] = temp;
         }
       }
    }
    for(int i=0; i<len; i++)
    {
       if(ch[i] != ' ')
       {
          System.out.print(ch[i] + " ");
       }
    }
    System.out.println();
  }

  public int[] splitandarrange(char[] ch)
  {
    int len = ch.length;
    int []count = new int[len];
    for(int i=0; i<len; i++)
    {
       count[i] = 1;
       for(int j=i+1; j<len; j++)
       {
         if(ch[i] == ch[j])
         {
           count[i]++;
         }
       }
       for(int k=i-1; k>=0; k--)
       {
         if(ch[i] == ch[k])
         {
            count[i] = 0;
            ch[i] = ' ';
         }
       }
    }
    return count;
  }
  
  public void wordswap(String s)
  {
    s = s.toLowerCase();
    char[] ch = s.toCharArray();
    int len = ch.length;
    char[] sc = new char[len];
    int k = 0;
    for(int i=0; i<len; i++)
    {
      if(ch[i] == ' ')
             k=i;
    }
    for(int i=0; i<len-k-1; i++)
    {
      sc[i] = ch[i+k+1];
    }
    sc[len-k-1] = ' ';
    for(int i=0; i<k; i++)
    {
      sc[len-k+i] = ch[i];
    }
    for(int i=0; i<len; i++)
    {
      System.out.print(sc[i]);
    }
    System.out.println();    
  }

  public void removecommon(String s)
  {
    s = s.toLowerCase();
    char[] ch = s.toCharArray();
    int len = ch.length;
    int blanklen = 0;
    for(int i=0; i<len; i++)
    {
      if(ch[i] == ' ')
             blanklen++;
    }
    int[] k = new int[blanklen];
    int v=0;
    for(int i=0; i<len; i++)
    {
      if(ch[i] == ' ')
      {
         k[v]=i;
         v++;
      }
    }
    int p = 0;
    for(int m=0; m<blanklen; m++)
    {
      int o = 0, t=0;
      for(int i=m; i<blanklen; i++)
      {
        int q = k[i] + 1;
        int z = i == blanklen - 1 ? len-1 : k[i+1] - 1;
        while(q <= z)
        {
          int u = p < k[0] ? 0 : k[m] + 1;
          if(ch[p] == ' ' || ch[p] != ch[q])
          {
            if(q >= k[blanklen-1] + 1)
            {
              for(int y = u; y < k[m]; y++)
              {
                if(o > 0)
                {
                  ch[y] = ' ';
                }
              }
            }
            break;
          }
          else
          {
            o++;
            int g = p < k[0] ? k[0] : k[m] - k[m-1];
            if(o <= g)
            {
              System.out.print(ch[q]);
            }
            if(q >= k[blanklen-1] + 1)
            {
              ch[p] = ' ';
            }
            ch[q] = ' ';
          }
          p++;
          q++;
        }
        p = p <= k[0] ? 0 : k[m-1] + 1;
        if(o != 0)
        {
          t++;
        }
      }
      p = k[m] + 1;
      if(t > 0)
          System.out.println();
    }
    System.out.println();
    for(int i=0; i<len; i++)
    {
        System.out.print(ch[i]);
    }
  }
}

class Pro13
{
  public static void main(String[] args)
  {
    ArrayManipulation am = new ArrayManipulation();
    am.operateOnArray();
  }
}




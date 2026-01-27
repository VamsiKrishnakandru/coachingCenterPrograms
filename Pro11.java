//interview Question - break a sentence into multiple words without using string methods and write the sentence in reverse order.
//Enter a sentence: This is a sentence
//This
//is
//a
//sentence
//sentence a is This


import java.util.Scanner;

class SplitString
{
  public void split()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a sentence: ");
    String s = scan.nextLine();
    char[] c = s.toCharArray();
    int l = 0;
    for(char ch: c)
    {
      if(ch==' ')
      {
        l++;
      }
    }
    String[] sa = new String[l+1];
    int k = 0;
    for(int i=0; i<l+1; i++)
    {
      sa[i] = "";
      for(int j=k; j<c.length; j++)
      {
        if(c[j]!=' ')
        {
          sa[i] = sa[i] + c[j];
        }
        else
        {
          k = ++j;
	  break;
        }
      }
    }
    for(String st: sa)
    {
      System.out.println(st);
    }
    for(int i=l; i>=0; i--)
    {
      System.out.print(sa[i] + " ");
    }
  }
}

class Pro11
{
  public static void main(String[] args)
  {
    SplitString s = new SplitString();
    s.split();
  }
}



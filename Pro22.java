//display the longest prefix in the given strings
//raghu

class StringPrefix
{
  String[] names = {"nave",  "naveee" , "raghu", "nae", "raghuuu" };
  public void findPrefix()
  {
    char[] s1 = new char[10];
    for(int i=0; i<names.length; i++)
    {
      char[] s2 = names[i].toCharArray();
      for(int j=i+1; j<names.length; j++)
      {
        int c=0, k=0;
        char[] s3 = names[j].toCharArray();
        int len2 = chararlength(s2);
        int len3 = chararlength(s3);
        while(k<len2 && k<len3)
        {
          if(s3[k] == s2[k])
          {
            c++;
          }
          else
            break;
          k++;
        }
        int len1 = chararlength(s1);
        if(c>len1)
        {
          for(int t=0; t<c; t++)
          {
            s1[t] = s2[t];
          }
        }
      }
    }
    int len1 = chararlength(s1);
    for(int i=0; i<len1; i++)
    {
      System.out.print(s1[i]);
    }
  }

  public int chararlength(char[] temp)
  {
    int k = 0;
    for(int i=0; i<temp.length; i++)
    {
      if(temp[i] != '\u0000')
        k++;
    }
    return k;
  }
}

class Pro22
{
 public static void main(String[] args)
 {
   StringPrefix sp = new StringPrefix();
   sp.findPrefix();
 }
}
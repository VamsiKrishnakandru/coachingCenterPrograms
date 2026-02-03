/*
For given two strings S -> main string, T -> target string
Find the smallest substring in S that contains all chars of T (including duplicates)
if not found -> return empty string.
O/P - 
S = ADOBECODEBANC
T = ABC
ADOBEC
BECODEBA
CODEBA
BANC

Smallest substring: BANC
*/

class FindSubstring
{
  String S = "ADOBECODEBANC", T ="ABC";
  public void find()
  {
    String[] subs = new String[S.length() - T.length() + 1];
    char[] ch1 = S.toCharArray(), ch2 = T.toCharArray();
    System.out.println("S = "+ S);
    System.out.println("T = "+ T);
    int k = 0;
    while(k <= S.length() - T.length())
    {
      int z = 0, u1=0, o = k, u2 = 0;
      char[] temp1 = new char[S.length()];
      char[] temp = T.toCharArray();
      for(int i=k; i<S.length(); i++)
      {
        int q=i;
        int w = 0, j=0;
        while(j<T.length() && q<S.length())
        {
          if(ch1[q] == temp[j])
          {
            u2 = u1;
            temp[j] = ' ';
            j = 0;
            u1++;
            q++;
            i++;
            temp1[o] += ch1[o];
            o++;
            z++;
          }
          else
          {
            j++;
          }
          if(u1 == 0 && j == T.length())
          {
            i=S.length();
            break;
          }
          int b = 0;
          for(int u=0; u<T.length(); u++)
          {
            if(temp[u] == ' ')
                b++;
          }
          if(b<T.length() && u1 > 0 && j==T.length() && u1!=u2+1)
          {
            temp1[o] += ch1[o];
            o++;
            z++;
          }
          if(b < T.length() &&  o==S.length() && (j==T.length() || u1==u2+1))
          {
             for(int a=0; a<S.length(); a++)
             {
               temp1[a] = ' ';
             }
             break;
          }
          if(b == T.length() && o<S.length())
          {
            q=S.length();
            i=S.length();
            break;
          }
          w++;
          u2++;
        }
      }
      if(z >= T.length())
      {
        subs[k] = "";
        for(int m=0; m<S.length(); m++)
               subs[k] += temp1[m];
      }
      k++;
    }
    for(int i = 0; i < subs.length; i++)
    {
      if(subs[i] == null)
          subs[i] = "";
      else
          System.out.println(subs[i]);
    }
    int maxlen=S.length(), maxlenindex=0;
    for(int i = 0; i < subs.length; i++)
    {
      int len = 0;
      if(subs[i] != "")
      {
      char[] temp2 = subs[i].toCharArray();
      for(int j=0; j<S.length(); j++)
      {
         if(temp2[j] != '\u0000')
              len++;
      }
      if(maxlen > len && len!=0)
      {
        maxlenindex = i;
        maxlen = subs[i].length();
      }
      }
    }
    System.out.println("Smallest substring: " + subs[maxlenindex]);
  }
}

class Pro25
{
  public static void main(String[] args)
  {
    FindSubstring fs = new FindSubstring();
    fs.find();
  } 
}
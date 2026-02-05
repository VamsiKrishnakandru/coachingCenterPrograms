/*
Make combination of substrings using strings in "words" Ex - foobar and barfoo
If these substrings are present in "s" then return starting index in "s".
input -
s = "barfoofoobarthefoobarman"
words = {"foo", "bar", "the"}
O/P - 
1: foobarthe
2: foothebar
3: barfoothe
4: barthefoo
5: thefoobar
6: thebarfoo
6, 9, 12,
Note 1 - when doing recursion using char array - char array is an object and its reference given to next method call so all the operations done on it will reflect in the current method. 
need to reintialize after every method call to original char array. In below program we have two places this happens.
Note 2 - while copying two 2 dimension char array use two loops.
*/

class FindSubString
{
  String s = "barfoofoobarthefoobarman";
  String[] subs = {"foo", "bar", "the", "man"};
  char[][] combs;
  int k = 0;

  public void findcomb()
  {
    int len1 = subs[0].length();
    int len2 = fact(subs.length);
    int len3 = subs.length * subs[0].length();
    combs = new char[len2][len3];
    char[][] o = new char[subs.length][subs[0].length()];
    char[][] jk = new char[subs.length][subs[0].length()];
    for(int i=0; i<subs.length; i++)
    {
      o[i] = subs[i].toCharArray();
      jk[i] = subs[i].toCharArray();
    }
    for(int i=0; i<subs.length; i++)
    {
      char[] tempss = new char[len3];
      makeC(tempss, 0, i, o);
      for(int io=0; io<subs.length; io++)
      {
        for(int j=0; j<subs[0].length(); j++)
                 o[io][j] = jk[io][j];
      }
    }
    for(int i=0; i<len2; i++)
    {
      System.out.print((i+1)+": ");
      for(int j=0; j<len3; j++)
          System.out.print(combs[i][j]);
      System.out.println();
    }
    char[] temps = s.toCharArray();
    for(int i=0; i<s.length(); i++)
    {
       for(int j=0; j<len2; j++)
       {
         if(temps[i] == combs[j][0])
         {
           compare(temps, combs[j], i);
         }
       }
    }   
  }
 
  public void compare(char[] temps, char[] combs, int k)
  {
     boolean issame = false;
     int j = 0;
     if(s.length()-k >= combs.length)
     {
     for(int i=k; i<s.length(); i++)
     {
       if(j<combs.length - 1 && temps[i] == combs[j])
       {
          issame = true;
       }
       else if(j==combs.length-1 && temps[i] == combs[j])
       {
         issame = true;
         break;
       }
       else
       {
         issame = false;
         break;
       }
       j++;
     }
     }
     if(issame)
     {
       System.out.print(k + ", ");
     }
  }

  public void makeC(char[] tempss, int num, int templen, char[][] tempsubs)
  {
    int len3 = subs.length * subs[0].length();
    char[][] temptempsubs = new char[subs.length][subs[0].length()];
    if(num == len3-subs[0].length())
    {
      char[] tempcha = tempsubs[templen];
      for(int i=0; i<subs[0].length(); i++)
      {
         tempss[num+i] = tempcha[i];
      }
      for(int i=0; i<len3; i++)
      {
        combs[k][i] = tempss[i];
      }
      k++;
      return;
    }
    char[] tempcha = tempsubs[templen];
    for(int i=0; i<subs[0].length(); i++)
    {
       tempss[num+i] = tempcha[i];
    }  
    tempsubs[templen][0] = ' ';
    for(int i=0; i<subs.length; i++)
    {
      for(int j=0; j<subs[0].length(); j++)
         temptempsubs[i][j] = tempsubs[i][j];
    }
    for(int i=0; i<subs.length; i++)
    { 
      if(tempsubs[i][0] != ' ')
      {
        makeC(tempss, num+3, i, tempsubs);
        for(int io=0; io<subs.length; io++)
        {
          for(int j=0; j<subs[0].length(); j++)
                    tempsubs[io][j]=temptempsubs[io][j];
        }
      }
    }
  }

  public int fact(int num)
  {
    if(num==1)
        return num;
    return num * fact(num-1);
  } 
}

class Pro28
{
  public static void main(String[] args)
  {
    FindSubString fs = new FindSubString();
    fs.findcomb();
  }
}
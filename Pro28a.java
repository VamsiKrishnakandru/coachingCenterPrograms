/*
words = {"f", "b", "t"}
O/P -
1: fbt
2: ftb
3: bft
4: btf
5: tfb
6: tbf 
*/

class FindSubString
{
  String s = "barfoothefoobarman";
  String[] subs = {"f", "b", "t"};
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
    for(int i=0; i<len3; i++)
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
  }

  public void makeC(char[] tempss, int num, int templen, char[][] tempsubs)
  {
    int len3 = subs.length * subs[0].length();
    char[][] temptempsubs = new char[subs.length][subs[0].length()];
    if(num == len3 - 1)
    {
      char[] tempcha = tempsubs[templen];
      char tempch = tempcha[0];
      tempss[num] = tempch;
      for(int i=0; i<len3; i++)
      {
        combs[k][i] = tempss[i];
      }
      k++;
      return;
    }
    char[] tempcha = tempsubs[templen];
    char tempch = tempcha[0];
    tempss[num] = tempch;
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
        makeC(tempss, num+1, i, tempsubs);
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

class Pro28a
{
  public static void main(String[] args)
  {
    FindSubString fs = new FindSubString();
    fs.findcomb();
  }
}
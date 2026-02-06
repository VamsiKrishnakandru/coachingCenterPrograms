/*
Given 2 strings S1 and S2.
if S1.length()=1 and S1=S2 --> true
if S1.length()>1: 
        recursively:
             split S1 into x and y such that S1=x+y
             randomly rearrange x and y i.e, S1=x+y or S1=y+x 
             go back with x and y and recursively split them and rearrange them
final String S1 is compared with S2 and returns true if S1 and S2 are equal.                      
O/P - 

*/

class ScrambleString
{
  String S1 = "great", S2 = "rgeat"; 
  String[] store = new String[100];
  int t = 0;
  public void scramble()
  {
    char[] ch1 = new char[S1.length()]; 
    ch1=S1.toCharArray();
    for(int i=0; i<100; i++)
       store[i]= "";
    scram(ch1, 0, ch1.length-1, 0);
    for(int i=0; i<100; i++)
        if(store[i]!="")
           System.out.println((i+1) + ": " +store[i]);
    for(int i=0; i<100; i++)
    {
       if(store[i].equals(S2))
       {
         System.out.println("true");
         break;
       }
    }
  }

  public void scram(char[] tempch, int l, int r, int m)
  {
    if(m==2)
    {
      boolean check = true;
      String s = "";
      for(int j=0; j<tempch.length; j++)
                  s += tempch[j];
      for(int i=0; i<100; i++)
      {
        if(s.equals(store[i]))
           check = false;
      }
      if(check)
      {
        store[t] = "";
        for(int i=0; i<tempch.length; i++)
          store[t] += tempch[i];
        t++;
      }
      return;
    }
    char[] swaptempch1 = new char[tempch.length];
       for(int i=0; i<tempch.length; i++)
          swaptempch1[i] = tempch[i];
    char[] swaptempch = new char[tempch.length];
       for(int i=0; i<tempch.length; i++)
          swaptempch[i] = swaptempch1[i];
    for(int z=l; z<=r; z++) 
    {
       for(int i=0; i<tempch.length; i++)
          tempch[i] = swaptempch[i];
       for(int i=0; i<tempch.length; i++)
          swaptempch1[i] = swaptempch[i];
       int q=0, p=0;
       for(int i=0; i<tempch.length; i++)
       {
          if(i<l || i>r)
          {
             tempch[i] = swaptempch1[i];
          }
          if(i>=l && i <= l+r-z-1)
          {
            tempch[i] = swaptempch1[z+1+q];
            q++;
          }
          else if(i>=l+r-z && i<=r)
          {
             tempch[i] = swaptempch1[l+p];
             p++;
          }
       }
       char[] swaptempch2 = new char[tempch.length];
       for(int i=0; i<tempch.length; i++)
           swaptempch2[i] = tempch[i];
       scram(tempch, l, l+r-z-1, m+1);
       for(int i=0; i<tempch.length; i++)
           tempch[i] = swaptempch2[i];
       scram(tempch, l+r-z, r, m+1); 
       scram(swaptempch1, l, z, m+1);
       for(int i=0; i<tempch.length; i++)
             swaptempch1[i] = swaptempch[i];
       scram(swaptempch1, z+1, r, m+1);
    }
  }
}

class Pro29a
{
  public static void main(String[] args)
  {
    ScrambleString s = new ScrambleString();
    s.scramble();
  }
}


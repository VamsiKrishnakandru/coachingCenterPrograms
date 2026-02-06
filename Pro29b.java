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

import java.util.Random;

class ScrambleString
{
  String S1 = "great", S2 = "rgeat";
  public void scramble()
  {
    char[] ch1 = new char[S1.length()]; 
    ch1=S1.toCharArray();
    scram(ch1, 0, ch1.length-1);
    String Stemp = "";
    for(int i=0; i<S1.length(); i++)
      Stemp = Stemp + ch1[i];
    System.out.println(Stemp);
    if(Stemp.equals(S2))
           System.out.println(true);
    else
           System.out.println(false);
  }

  public void scram(char[] tempch, int l, int r)
  {
    if(r-l==0)
    {
      return;
    }
    Random rand = new Random();
    int k=rand.nextInt(2), z=rand.nextInt(r-l) + l;
    char[] swaptempch = new char[tempch.length];
    for(int i=0; i<tempch.length; i++)
          swaptempch[i] = tempch[i];
    if(k==0)
    {
       int q=0, p=0;
       for(int i=0; i<tempch.length; i++)
       {
          if(i<l || i>r)
          {
             tempch[i] = swaptempch[i];
          }
          if(i>=l && i <= l+r-z-1)
          {
            tempch[i] = swaptempch[z+1+q];
            q++;
          }
          else if(i>=l+r-z && i<=r)
          {
             tempch[i] = swaptempch[l+p];
             p++;
          }
       }
    }
    else if(k==1)
    {
       for(int i=0; i<tempch.length; i++)
                   swaptempch[i] = tempch[i];
    }
    scram(tempch, l, l+r-z-1);
    scram(tempch, l+r-z, r);
  }
}

class Pro29b
{
  public static void main(String[] args)
  {
    ScrambleString s = new ScrambleString();
    s.scramble();
  }
}


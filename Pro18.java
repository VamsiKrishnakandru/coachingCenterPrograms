/*
Find if two strings are a pair of anagrams or not.
O/P - 
Enter the first string: archer
Enter the second string: ahrrce
It is an Anogram
*/

import java.util.Scanner;

class Anagram
{
  public void verifyAnagram()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the first string: ");
    String s1 = scan.next();
    System.out.print("Enter the second string: ");
    String s2 = scan.next();
    boolean d = true;
    if(s1.length() == s2.length())
    {
      char[] ch1 = s1.toCharArray();
      char[] ch2 = s2.toCharArray();
      int[] k= new int[s1.length()];
      for(int i=0; i<s1.length(); i++)
      {
        for(int j=0; j<s1.length(); j++)
        {
           if(ch1[i] == ch2[j])
           {
             k[i]++;
           } 
        }
        if(k[i]==0)
        {
           d = false;
           System.out.println("Not an Anogram");
           break;
        }
      }
      if(d)
      {
        if(solveK(k))
           System.out.println("It is an Anogram");
        else
           System.out.println("Not an Anogram");
      }
    }
    else
       System.out.println("Not an Anogram"); 
  } 
  
  public boolean solveK(int[] k)
  {
    for(int i=0; i<k.length; i++)
    {
      int t = 0;
      for(int j=0; j<k.length; j++)
      {
        if(k[i] == k[j])
        {
          t++;
        }
      }
      if(t%k[i] != 0)
      {
        return false;
      }
    }
    return true;
  }
}


class Pro18
{
  public static void main(String[] args)
  {
    Anagram a = new Anagram();
    a.verifyAnagram();
  }
}
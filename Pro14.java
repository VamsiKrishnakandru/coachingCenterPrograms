//Print all the permutations formed be rearranging the characters of the string.

import java.util.Scanner;

class StringPermutation
{
  public void printPermutation()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the String: ");
    String s = scan.next();
    int len = s.length(), count=0;
    char[] tempch = new char[len];
    tempch = s.toCharArray();
    
    for(int k=0; k<len; k++)
    {
      for(int i=0; i<len-1; i++)
      {
        for(int j=i+1; j<=len-1; j++)
        {
          if(!(j==k || i==k))
          {
            count++;
            System.out.print(count + ". ");
            for(int m=0; m<len; m++)
            {
              System.out.print(tempch[m]); 
            }
            System.out.println();
            char temp = tempch[j];
            tempch[j] = tempch[i];
            tempch[i] = temp;
            count++;
            System.out.print(count + ". ");
            for(int m=0; m<len; m++)
            {
              System.out.print(tempch[m]); 
            }
            System.out.println();
          }
        }
      }
      char temp = tempch[k];
      if(k != len-1)
      {
        tempch[k] = tempch[k+1];
        tempch[k+1] = temp;
      }
    }
  }
}

class Pro14
{
  public static void main(String[] args)
  {
    StringPermutation sp = new StringPermutation();
    sp.printPermutation();
  }
}
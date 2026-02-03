/*Print all the permutations formed be rearranging the characters of the string of length 4.
Enter the String with length less than 4: this

1. htis
2. hits
3. hist
4. tsih
5. tish
6. hsit
7. ihst
8. isht
9. isth
10. htsi
11. hsti
12. itsh
13. sith
14. stih
15. sthi
16. ihts
17. iths
18. shti
19. tshi
20. thsi
21. this
22. siht
23. shit
24. tihs
*/

import java.util.Scanner;

class StringPermutation
{
  public void printPermutation()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the String with length less than 4: ");
    String s = scan.next();
    int len = s.length(), count=0, l = 0;
    char[] tempch = new char[len];
    tempch = s.toCharArray();
    char[] ch = new char[len];
    ch = s.toCharArray();
      do
      {
        //System.out.println("hi");
        for(int i=0; i<len-1; i++)
        {
            l++;
            System.out.println();
            char temp = tempch[i];
            tempch[i] = tempch[i+1];
            tempch[i+1] = temp;
            count++;
            System.out.print(count + ". ");
            for(int m=0; m<len; m++)
            {
              System.out.print(tempch[m]); 
            }
            if(l%3 == 0 && len > 3)
            {
              count++;
              System.out.println();
              System.out.print(count + ". ");
              for(int m=len-1; m>=0; m--)
              {
                System.out.print(tempch[m]); 
              }
              count++;
              System.out.println();
              System.out.print(count + ". ");
              for(int h=0; h<2; h++)
              {
                for(int m=len-1-h; m>=0; m=m-2)
                {
                  System.out.print(tempch[m]); 
                }
              }
              count++;
              System.out.println();
              System.out.print(count + ". ");
              for(int h=0; h<2; h++)
              {
                for(int m=h; m<4; m=m+2)
                {
                  System.out.print(tempch[m]); 
                }
              }
            }
        }
        //System.out.println(compare(ch, tempch, len));
      }
      while(!compare(ch, tempch, len));
  }
  
  public boolean compare(char[] ch, char[] tempch, int len)
  {
    for(int i=0; i<len; i++)
    {
      if(ch[i] != tempch[i])
      {
        return false;
      }
    }
    return true;
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
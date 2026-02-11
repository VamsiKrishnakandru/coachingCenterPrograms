/*
Decode the pattern and print the string 
I/P -
3[a2[c]]
O/P - 
accaccacc
*/


class DecodePattern
{
  String pattern = "3[a2[c]]";
  int a = 5;
  public void decode()
  {
    char[] temp = pattern.toCharArray();
    int k=0;
    for(int i=0; i<pattern.length(); i++)
      if(temp[i] == '[')
                  k++;
    char[][] temp1 = new char[k][a];
    int[][] n = new int[k][2];
    int y=0;
    for(int i=0; i<pattern.length()-1; i++)
    { 
      if(temp[i] == '[')
      {
         int l=i+1, z=0;
         while(temp[l] >= 'a' && temp[l] <= 'z')
         {
            temp1[y][z] = temp[l];
            l++;
            z++;
         }
         n[y][1] = z;
         n[y][0] = temp[i-1];
         n[y][0] -= 48;
         y++;
      }
    }

    int total = 0;
    for(int i=k-1; i>=0; i--)
    {
       total = n[i][0] * (total + n[i][1]);
    }
 
    String finals = "";
    String temp2 = new String();

    for(int i=k-1; i>=0; i--)
    {
       int u=0;
       temp2 = "";
       while(u < n[i][0])
       {
         for(int j=0; j<n[i][1]; j++)
         {
           temp2 = temp2 + temp1[i][j];
         }
         u++;
         temp2 = temp2 + finals;
       }
       finals = temp2;
    }
    System.out.println(finals);
  }
}


class Pro35
{
  public static void main(String[] args)
  {
    DecodePattern dp = new DecodePattern();
    dp.decode();
  }
}
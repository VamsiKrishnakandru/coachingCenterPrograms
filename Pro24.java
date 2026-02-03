/*
For a given set of words find the alphabets that are not repeating in any of the strings.
Given - {"aabbcc", "swiss", "programming", "aabb"}
O/P - 

*/

class NonRepeating
{
  String[] words = {"aabbcc", "swiss", "programming", "aabb"};
  public void findchar()
  {
    String full = "";
    for(int i=0; i<words.length; i++)
    {
      full += words[i];
    }
    int len = full.length();
    char[] fulls = full.toCharArray();
    for(int i=0; i<len; i++)
    {
      int k = 0;
      for(int j=i+1; j<len; j++)
      {
         if(fulls[i] == fulls[j])
         {
           fulls[j] = ' ';
           k++;
         }
      }
      if(k>0)
           fulls[i] = ' ';
    }
    for(int i=0; i<len; i++)
    {
      if(fulls[i] != ' ')
         System.out.print(fulls[i] + " ");
    }
  }
}

class Pro24
{
  public static void main(String[] args)
  {
    NonRepeating nr = new NonRepeating();
    nr.findchar();
  }
}
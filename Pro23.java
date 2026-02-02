//find group of anagram words in a set of words.
//anagram
//nagaram
//graamna

class AnagramGroup
{
  String[] words = {"anagram","nagaram","ramdom","graamna", "turkey"}; 
  public void findAnagram()
  {
    int[] places = new int[words.length];
    for(int i=0; i<words.length; i++)
    {
      for(int j=i+1; j<words.length; j++)
      {
        boolean isAnagram = isAnagram(words[i], words[j]);
        if(isAnagram)
        {
           places[i]++;
           places[j]++;
        }
      }
    }
    for(int i=0; i<words.length; i++)
    { 
      if(places[i] != 0)
      {
        System.out.println(words[i]);
      }
    }
  }
  
  public boolean isAnagram(String s1, String s2)
  {
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
           return false;
        }
      }
      if(d)
      {
        if(solveK(k))
           return true;
        else
           return false;
      }
    }
    return false;
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

class Pro23
{
  public static void main(String[] args)
  {
    AnagramGroup ag = new AnagramGroup();
    ag.findAnagram();
  }
}
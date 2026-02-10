/*
Input:beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
hit → hot → dot → dog → cog
*/


class StringOrder
{
  String start = "hit", end = "cog";
  String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
  public void findOrder()
  {
    for(int i=0; i<wordList.length; i++)
        if(wordList[i].equals(start) || wordList[i].equals(end))
               wordList[i] = "";

    char[] tempstart = start.toCharArray();
    char[] tempend = end.toCharArray();
    for(int j=0; j<wordList.length; j++)
    {  
       if(wordList[j] != "")
       {
          char[] temp1 = wordList[j].toCharArray();
          if(!(tempstart[0] >= temp1[0] && tempend[0] <= temp1[0]))
          {      
              wordList[j] = "";
              continue;
          }
          if(!(tempstart[1] <= temp1[1] && tempend[1] >= temp1[1]))
          {
              wordList[j] = "";
              continue;
          }
          if(!(tempstart[2] >= temp1[2] && tempend[2] <= temp1[2]))
              wordList[j] = "";
       }
    }
    System.out.print(start + " -> ");
    for(int i=0; i<wordList.length; i++)
       if(wordList[i] != "")
           System.out.print(wordList[i] + " -> ");
    System.out.println(end);
  }
}

class Pro33
{
  public static void main(String[] args)
  {
    StringOrder so = new StringOrder();
    so.findOrder();
  }
}

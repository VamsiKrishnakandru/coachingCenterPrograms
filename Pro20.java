/*
problem 417 in leetcode
below grid consists of hights is their respective corrdinaties.
water flows from higher region to neighbouring region in N,S,E,W directions
water finally enters either top or left and bottom or right.
O/P - 
Heights in a grid:
1 2 2 3 5
3 2 3 4 4
2 4 5 3 1
6 7 1 4 5
5 1 1 2 4
Corrdinates where water can flow to sea:
[0,4]
[1,3]
[1,4]
[2,2]
[3,0]
[3,1]
[4,0]
*/

class Rainfall
{
  int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
  public void predict()
  {
    System.out.println("Heights in a grid: ");
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        System.out.print(heights[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("Corrdinates where water can flow to sea: ");
    for(int i=0; i<5; i++)
    {
      for(int j=0; j<5; j++)
      {
        boolean k=false, l=false;
        k=isWaterflow(i, j, 0);
        l=isWaterflow(i, j, 4);
        if(k && l) 
             System.out.println("["+i+","+j+"]");
      }
    }
  }
  
  public boolean isWaterflow(int k, int l, int u)
  {
    //System.out.println(k + " - " + l + " - " + u);
    boolean q = false, w = false, e = false, r = false;
    if(k==u || l==u)
      return true;
    if(u==0)
    {
          if(heights[k][l] >= heights[k-1][l])
          {
            return isWaterflow(k-1,l,u);
          } else if(heights[k][l] >= heights[k][l-1])
          {
            return isWaterflow(k,l-1,u);
          }
    }
    else
    {
         if(heights[k][l] >= heights[k+1][l])
         {
            return isWaterflow(k+1,l,u);
         }else if(heights[k][l] >= heights[k][l+1])
         {
            return isWaterflow(k,l+1,u);
         }
    }
    return false;
  }
}

class Pro20
{
  public static void main(String[] args)
  {
    Rainfall r = new Rainfall();
    r.predict();
  }
}
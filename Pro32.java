/*
give array -  {2, 3, 5, 6, 28, 121, 5, 6, 2}
o/p - 
Unique Numbers: [2, 3, 5, 6, 28, 121]
Prime Numbers: [2, 3, 5, ]
Palindrom Numbers: [2, 3, 5, 6, 121, ]
Perfect Numbers: [6, 28, ]
Even sum: 36
odd sum: 129
*/


class Findnums
{
  int[] ar = {2, 3, 5, 6, 28, 121, 5, 6, 2};
  
  public void operate()
  {
    int q=0;
    for(int i=0; i<ar.length; i++)
    {
       for(int j=0; j<ar.length; j++)
       {
         if(i!=j && ar[j] == ar[i])
         {
            ar[j] = 0;
         }
       }
    }
    
    for(int i=0; i<ar.length; i++)
         if(ar[i] != 0)
             q++;

    int[] temp = new int[q];
   
    q=0;
    for(int i=0; i<ar.length; i++)
       if(ar[i] != 0)
       {
         temp[q] = ar[i];
         q++;
       }
    System.out.print("Unique Numbers: [");
    for(int i=0; i<q-1; i++)
        System.out.print(temp[i] + ", ");
    System.out.println(temp[q-1] + "]");
    
    int[] temp1 = new int[q];
    for(int i=0; i<q; i++)
      temp1[i] = temp[i]; 
    for(int i=0; i<q; i++)
      for(int j=2; j<temp[i]/2; j++)
         if(temp[i]%j == 0)
               temp[i]=0; 
    
    System.out.print("Prime Numbers: [");
    for(int i=0; i<q; i++)
       if(temp[i] != 0)
           System.out.print(temp[i] + ", "); 
    System.out.println("]");

    for(int i=0; i<q; i++)
      temp[i] = temp1[i]; 
    
    for(int i=0; i<q; i++)
       if(!findpalindrom(temp[i]))
          temp[i] = 0;
     
    System.out.print("Palindrom Numbers: [");
    for(int i=0; i<q; i++)
       if(temp[i] != 0)
           System.out.print(temp[i] + ", "); 
    System.out.println("]");

    for(int i=0; i<q; i++)
      temp[i] = temp1[i]; 
    
    for(int i=0; i<q; i++)
       if(!findperfectnumber(temp[i]))
          temp[i] = 0;
     
    System.out.print("Perfect Numbers: [");
    for(int i=0; i<q; i++)
       if(temp[i] != 0)
           System.out.print(temp[i] + ", "); 
    System.out.println("]");
    int evensum = 0, oddsum=0;
    for(int i=0; i<q; i++)
        if(temp1[i]%2==0)
           evensum+=temp1[i];
    System.out.println("Even sum: " + evensum);
    for(int i=0; i<q; i++)
        if(temp1[i]%2==1)
           oddsum+=temp1[i];
    System.out.println("odd sum: " + oddsum);       
  }

  public boolean findperfectnumber(int a)
  {
    boolean isperfectnumber = false;
    int sum=0;
    for(int i=1; i<=a/2; i++)
    {
      if(a%i==0)
         sum+=i;
    }
    if(sum==a)
        isperfectnumber=true;
    
    return isperfectnumber;
  }

  public boolean findpalindrom(int a)
  {
    boolean ispalindrom = true;
    int j=0, k=a;
    while(k > 0)
    {
       k=k/10;
       j++;
    }
    int[] t = new int[j];
    j=0;
    k=a;
    while(k > 0)
    {
       t[j] = k%10;
       k=k/10;
       j++;
    }
    for(int i=0; i<j; i++)
       if(t[i] != t[j-i-1])
           ispalindrom = false;
         
    return ispalindrom;
  }
}

class Pro32
{
  public static void main(String[] args)
  {
     Findnums fn = new Findnums();
     fn.operate();
  }
}
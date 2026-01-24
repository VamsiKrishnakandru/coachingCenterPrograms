//program to run three different operations
//operation 1 - ask for number -> add the digits of the number util only 1 digit remains -> factorial of that digit
//operation 2 - ask for number -> check if it is palindrom or not
//operation 3 - ask for string -> check if if is palindrom or not 

import java.util.Scanner;

class Operations
{
  public void performOperation()
  {
    String op = "";
    int factn = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Available operations: fact, npal, spal");
    System.out.print("Enter the operation you want to perform: ");
    op = scan.next();
    switch(op)
    {
      case "fact":
                  System.out.print("Enter the number: ");
                  factn = scan.nextInt();
                  int u=0;
                  while(factn/10!=0)
                  {
                    int temp = 0;
                    while(factn!=0)
                    {
                      int k=(factn/10) * 10;
                      temp += (k/10!=0) ? factn%k : factn;
                      factn=factn/10;
                    }
                    factn=temp;
                    u++;
                    System.out.println("number after " + u + " iteration is " + factn);
                  }
                  factn = findFactorial(factn);
                  System.out.println("Factorial of the digits of the " + factn + " is: " + factn);
                  break;
      case "npal":
                  System.out.print("Enter the number: ");
                  int num = scan.nextInt();
                  int len = 0, i=0, copy = num;
                  while(copy!=0)
                  {
                    len++;
                    copy=copy/10;
                  }
                  int[] a = new int[len]; 
                  while(num!=0)
                  {
                    int j=(num/10) * 10;
                    a[i] += (j/10!=0) ? num%j : num;
                    num=num/10;
                    i++;
                  }
                  for(int l=0; l<len; l++)
                  { 
                    if(a[l] != a[len-1-l])
                    {
                      System.out.println("Entered number is not palindrom");
                      return;
                    }
                  }
                  System.out.println("Entered number is a palindrom");
                  break;
      case "spal":
                  System.out.print("Enter the String: ");
                  String enteredstr = scan.next();
                  char[] str = enteredstr.toCharArray();
                  for(int l=0; l<str.length; l++)
                  { 
                    if(str[l] != str[str.length-l-1])
                    {
                      System.out.println("Entered string is not palindrom");
                      return;
                    }
                  }
                  System.out.println("Entered string is a palindrom");
                  break;
      default:
             System.out.println("Operation not available.");
    }
  }
  
  public int findFactorial(int n)
  {
    if(n==0)
    {
      return 1;
    }
    return n * findFactorial(n-1);
  }
}

class Pro6
{
  public static void main(String[] args)
  {
    Operations op = new Operations();
    op.performOperation();
  }
}
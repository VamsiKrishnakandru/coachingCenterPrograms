//first program
//Java has 3 modules - JSE-java standard edition, JEE-Java enterprise edition, JME - Java micro edition
//javac programname.java
//java classname
//1st Question - what is the difference between java code and class code? -> java code is java syntax, class code is byte format. 
//2nd Question - Can we compile the code when the main method is absent? -> Yes, but when executing we get error, JVM cannot find main method.

class pro1
{
  int a = 10;
  int b = 20;
  String c = "Ram";
  String d = "Rahul";
  double e = 300.00;
  double f = 400.00;

  static void add()
  {
    System.out.println(a+b);
  }

  void compare()
  {
    System.out.println(e>f);
  }

  void forLoop()
  {
    for(int i = 0; i<10; i++)
    {
      System.out.println(d);
    }
  }
  
  public static void main(String[] args)
  {
    pro1 p = new pro1(); //It is compulsory to write atleast 1 object for running methods (except when static)
    p.add();
    p.compare();
    p.forLoop();
  }
}
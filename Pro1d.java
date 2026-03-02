/*
   Method overloading using Variable arguments concept.
*/

class Overloading
{
  private int orderCount;
  private int orderNumber=0;
 
  public void display(String...dish)
  {
     orderCount = dish.length;
     orderNumber++;
     System.out.println("Order Number " + orderNumber);
     System.out.print("Order details : ");
     for(String item: dish)
        System.out.print(item + ", ");
     System.out.println();
     System.out.println("Order count: " + orderCount); 
     System.out.println("==========================");
  }
}

class Pro1d
{
  public static void main(String[] args)
  {
    Overloading ol = new Overloading();
    ol.display("Idli", "Dosa", "wada", "puri");
    ol.display("Idli", "Dosa");
    ol.display("Idli", "Dosa", "wada", "puri", "bonda");
  }
}

public class Help implements Runnable{

   public static void main(String[] args) {
      new Help().run();
   }

   @Override
   public void run()
   {
      System.out.println("");

      System.out.println("These classes will bring up a new window:");

      System.out.println("Main");
      System.out.println("Snake");
      System.out.println("ListDemo");
      System.out.println("ColorfulCircles");
      System.out.println("ConcurrentModel");
      System.out.println("HelloWorldGUI2");
      System.out.println("ComboBoxDemo");
      System.out.println("JavaFXControls");
      // not working for some reason right now
//       System.out.println("ThreeDBall"); 
      System.out.println("");

      System.out.println("These classes will output to the console:");
      System.out.println("Help");
      System.out.println("Threads");

      System.out.println("");
   }

}
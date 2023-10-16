import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution1 {

  public static void main(String[] args) {
    System.out.println("Hello, Assignment Question 1, Solution is as follows-");
    Scanner kb = new Scanner(System.in);
    System.out.println("enter 2 integers");
    try {
      int a = kb.nextInt();
      int b = kb.nextInt();
      int c = a / b; //ArithmeticException
      System.out.println("Div is " + c);
    } catch (ArithmeticException e) {
      System.out.println("ArithmeticException occurs");
    } catch (InputMismatchException e) {
      System.out.println("InputMismatchException occurs");
    } catch (Exception e) {
      System.out.println("Exception occurs");
    }
    System.out.println("code finished");
  }
}

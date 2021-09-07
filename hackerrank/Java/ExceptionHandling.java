package hackerrank.Java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int x = scan.nextInt();
            int y = scan.nextInt();

            int result = x/y;
            System.out.println(result);

        } catch(InputMismatchException e) {
            System.out.println("java.lang.InputMismatchException");
        } catch(ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        } catch (Exception e) {
            System.out.println(e);
        }

        scan.close();
    }
}

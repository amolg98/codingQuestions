package hackerrank.Java;

import java.util.Scanner;


// class ZeroException extends Exception {
//     public ZeroException(String s) {
//         super(s);
//         // System.out.println("java.lang.Exception: n and p should not be zero.");
//     }
// }

// class NegativeException extends Exception {
//     public NegativeException(String s) {
//         super(s);
//         // System.out.println("java.lang.Exception: n or p should not be negative.");
//     }
// }

class MyCalculator {
    /**
     * Create the method long power(int, int) here.
     */

    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        } else if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
    
        long result = (long) Math.pow( (double) n, (double)p );
        return result;
    }
}

public class ExceptionHandlingPart2 {

    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int p = scan.nextInt();
            scan.close();
            System.out.println(my_calculator.power(n,p));

        } catch (Exception e) {
            // handle exception
            System.out.println(e);
        }
    }
}

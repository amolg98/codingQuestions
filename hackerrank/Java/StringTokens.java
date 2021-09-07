package hackerrank.Java;
import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Write your code here.
        String s = scan.nextLine().trim();
        scan.close();
        
        if (s.length() > 0) {    
            String[] strArr = s.split("[ !,?._'@]+");
            System.out.println(strArr.length);
            for (String str: strArr) {
                System.out.println(str);
            } 
        } else {
            System.out.println(s.length());
            scan.close();
            return;
        }
        
    }
}

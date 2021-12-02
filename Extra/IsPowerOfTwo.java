package Extra;

// import java.util.List;

public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int x) {
        if (x == 0) return false;

        return (int) (Math.ceil(Math.log(x)/Math.log(2))) == (int) (Math.floor(Math.log(x)/Math.log(2)));
    }
    public static void main(String[] args) {
        if (isPowerOfTwo(31)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        if (isPowerOfTwo(64)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if (isPowerOfTwo(32)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

package Extra;

public class fib {

    public static long fibonacci (int n) {
        if (n <= 1) {
            return n;
        }

        long[] ar = new long[n+2];
        ar[0] = 0;
        ar[1] = 1;

        for (int i=2; i<=n; i++)
            ar[i] = ar[i-1] + ar[i-2];

        return ar[n];
    }

    public static void main(String[] args) {

        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        long fib_val = 0;
        fib_val = fibonacci(150);
        System.out.println("Value is " + fib_val);

        // bufferedWriter.newLine();
        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
package Extra;

public class AltiMSolution {

    public int reverse(int x) {
        int y = 0;
        
        while(x != 0) {
            y = x%10 + (y*10);
            x = x/10;
        }

        return y;
    }

    public static void main(String[] args) {
        int x = 112;
        AltiMSolution solution = new AltiMSolution();
        System.out.println(solution.reverse(x));

        x = -94168136;
        System.out.println(solution.reverse(x));
    }
}
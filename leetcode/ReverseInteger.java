package leetcode;

// import java.util.Stack;

class Solution {

    // Method 1 using stack
    // public int reverse(int x) {
        
    //     int p = 0;
    //     boolean f = false;
    //     if (x < 0) {
    //         f = true;
    //         x = -x;
    //     }
    //     long val = 0;
    //     Stack<Integer> st = new Stack<>();
    //     while (x>0) {
    //         int y = x%10;
    //         st.push(y);
    //         x = x / 10;
    //     }
    //     while (! st.empty()) {
    //         val = val + (long) (Math.pow(10,p) * st.pop());
    //         p++;
    //     }
    //     if (f) val = -val;
    //     if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) return 0;
    //     return (int) val;
    // }

    // Method 2 - verify by reversing the reverse value
    public int reverse(int x) {
        int reverse, cross;
        reverse = rev(x);
        cross = rev(reverse);

        if (x == cross || x%cross == 0) {
            return reverse;
        }

        return 0;
    }

    public int rev(int x) {
        int reverse = 0;

        while (x != 0) {
            reverse = reverse*10 + (x%10);
            x = x/10;
        }
        return reverse;
    }

}
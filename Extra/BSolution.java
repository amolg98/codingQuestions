package Extra;

import java.util.List;
import java.util.ArrayList;

public class BSolution {

    public List<Integer> solutionA(int A, int B) {

        // write your code in Java SE 8
        String st_a = String.valueOf(A);
        String st_b = String.valueOf(B);

        int len_a = st_a.length();
        int len_b = st_b.length();

        List<Integer> output = new ArrayList<>();

        if (len_a > len_b) {
            output.add(-1);
        } else {
            for (int i=0; i < len_b; i++) {
                int l = len_b - i;
                if (l >= len_a) {
                    if (st_a.equals(st_b.substring(i,i+len_a))) { 
                        output.add(i);
                    }
                }
            }
        }

        if (output.isEmpty()) output.add(-1);

        return output;
    }

    public int solutionB(int A, int B) {
        int result = -1;
        // write your code in Java SE 8
        String st_a = String.valueOf(A);
        String st_b = String.valueOf(B);

        int len_a = st_a.length();
        int len_b = st_b.length();

        if (len_a > len_b) {
            return result;
        } 
        for (int i=0; i < (len_b - len_a + 1); i++) {
            // int l = len_b - i;
            
            if (st_a.equals(st_b.substring(i,i+len_a))) { 
                return i;
            }
        }

        return result;
    }

    public int solutionC(int A, int B) {
        // write your code in Java SE 8
        int result = 0;
        int start = (int) Math.floor(Math.sqrt(A));
        int end = (int) Math.floor(Math.sqrt(B));

        // System.out.println(start + " " + end);

        for (int i=start; i<=end; i++) {
            long p = i * (i+1);

            if (p > Integer.MAX_VALUE || p> B) return result;

            if (A <= p && p <= B) result++;
        }

        return result;

    }

    public void mergeMatrix(int[][] A, int i, int j, int rowLen, int colLen, int currColor) {
        if (i<0 || i>=rowLen || j<0 || j>= colLen || (A[i][j] < 0) || A[i][j] != currColor)
            return;

        A[i][j] = -1;

        mergeMatrix(A, i-1, j, rowLen, colLen, currColor);
        mergeMatrix(A, i+1, j, rowLen, colLen, currColor);
        mergeMatrix(A, i, j-1, rowLen, colLen, currColor);
        mergeMatrix(A, i, j+1, rowLen, colLen, currColor);
    }

    public int solutionD(int[][] A) {
        // write your code in Java SE 8
        int result = 0;

        if (A == null || A.length == 0 || A[0].length == 0) return result;

        int rowLen = A.length;
        int colLen = A[0].length;
        int currColor = -1;

        for (int i=0; i<rowLen; i++) {
            for (int j=0; j<colLen; j++) {
                if (A[i][j] > 0) {
                    currColor = A[i][j];
                    result++;
                    mergeMatrix(A, i, j, rowLen, colLen, currColor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}

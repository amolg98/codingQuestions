package leetcode;

public class RotateArray {

    public void rotate(int[] arr, int k) {
        int len = arr.length;
        k = k % len;

        reverse(arr, 0, len);
        reverse(arr, 0, k-1);
        reverse(arr, k, len);

    }

    public void reverse(int[] arr, int start, int end) {
        for (int i=start, j=end; i<j; i++, j--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void main(String[] args) {
        
        int[] ar = {1,2,3,4,5,6};

        for (int i=0; i < ar.length-1; i++) {
            System.out.println(ar[i]);
        }
    }
} 
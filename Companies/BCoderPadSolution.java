package Companies;

import java.util.*;

public class BCoderPadSolution {


    // n 
    // 1 <= Array[i] <= n+2
    // increasing and unique
    // 
    public static List<Integer> getNumbers(int[] arr) {
        List<Integer> result = new ArrayList<>();
        // boolean[] boolArr = new boolean[arr.length+2];
        
        // for (int i=0; i<arr.length; i++) {
        //     boolArr[arr[i]-1] = true;
        // }

        // for (int k=0; k<boolArr.length; k++) {
        //     if (!boolArr[k]) 
        //         result.add(k+1);
        // }

        int j=0;
        for (int i=0; (i<arr.length+2); i++, ++j) {
            if ((i+1) != arr[j]) {
                result.add(i+1);
            } else {
                if (j < arr.length-1) 
                    j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6};
        int[] arr1 = {2,3,4,5,6};
        int[] arr2 = {1,3,4,5,6};
        int[] arr3 = {1,2,3,4,5};
        
        System.out.println(getNumbers(arr));
        System.out.println(getNumbers(arr1));
        System.out.println(getNumbers(arr2));
        System.out.println(getNumbers(arr3));
       
       
    }
}

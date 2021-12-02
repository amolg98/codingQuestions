package Extra;

import java.util.StringBuilder;

public class OracleSolution {
    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        for (int i=0; i<s.length(); i++) {
            stringBuilder.add(s.charAt(len-1-i));
        }
        return stringBuilder.toString();
    }

    // Map<Integer, Integer>
    // List<Integer> length 2;

    public static int printSecondNumber(int[] input) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        List<Integer> res = new ArrayList<>();

        for (int i: input) {

            map.put(i, map.getOrDefault(i, 0)+1);
            int val = map.get(i);
            if (res.size() < 1) 
                res.add(i);
            else {
                if (val > res.get(1)) {
                    res.add(1, i);
                }
            }
        }

        if (res.size() > 1) 
            return res.get(1);
        
        return -1;

    }
    
    public static void main(String[] args) {
        String s = "HelloWorld";
        System.out.println(reverseString(s));
    }
}

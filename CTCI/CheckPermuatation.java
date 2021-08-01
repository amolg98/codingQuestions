package CTCI;

import java.util.Map;
import java.util.HashMap;

public class CheckPermuatation {
    
    public boolean checkPermuatation (String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        // If length is not equal then simply return false as strings won't be permutation of each other
        if (len1 != len2) return false; 

        /** Use Map Data Structure to store each character as a key 
         * and it's count in string as value 
         * 
         * */
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, (map.get(c)+1));
            } else {
                map.put(c, 1);
            }
        }

        /** Check for each character if no key found with character return false
         * If key found but count after removing that character is less than 0 return false
         * Otherwise if loop completes means we removed all characters and in equal proportion
         * return true
         * 
         * */ 
        for (char c: s2.toCharArray()) {
            if (map.containsKey(c)) {
                int val = map.get(c) - 1;
                if (val < 0) 
                    return false;
                else
                    map.put(c, val);
                
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "Uniqueal";
        String s2 = "Uniqeal";

        CheckPermuatation cP = new CheckPermuatation();
        System.out.println("Output is " + cP.checkPermuatation(s1, s2));

        s1 = "niqueal";
        s2 = "uniqeal";
        System.out.println("Output is " + cP.checkPermuatation(s1, s2));

    }
}

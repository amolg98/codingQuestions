package Extra;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import java.util.HashSet;

public class AllSubstrings {

    // public static void storeAllSubsequences(List<String> res, int start, int end, String s) {
    //     // System.out.println("2. start is " + start + " end is " + end);
    //     for (int i=start; i<end; i++) {
    //         // String s_1 = s.substring(start, i+1);
    //         // String s_2 = s.substring(i+1, end+1);
    //         // System.out.println("Strings are " + s_1 + " -- " + s_2);
    //         res.add(s.substring(start, i+1));
    //         res.add(s.substring(i+1, end+1));
    //     }
    // }

    // public static void subsequences(List<String> result, int start, int end, String s) {
    //     // System.out.println("1. start is " + start + " end is " + end);
    //     storeAllSubsequences(result, start, end, s);
    //     if (start < end) {
    //         subsequences(result, start+1, end-1, s);
    //     }

    // }

    public static void subStrings(String s, List<String> result) {

        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                // System.out.println(" i + " " + j +" s.substring(i, j));
                System.out.println(s.substring(i, j));
                result.add(s.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        String s = "Geeky";
        int value = 0;
        Set<String> strSet = new HashSet<>();
        List<String> results = new ArrayList<>();
        AllSubstrings.subStrings(s, results);
        
        for (String str : results) {
            // System.out.println(str);
            char charAr[] = str.toCharArray();

            // for (char c: charAr) System.out.println(c);

            Arrays.sort(charAr);
            str = new String(charAr);
            // System.out.println(str);
            if (strSet.contains(str)) {
                value++;
            } else {
                strSet.add(str);
            }
        }

        System.out.println(value);

    }
}

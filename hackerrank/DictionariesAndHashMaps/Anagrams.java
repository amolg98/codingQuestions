package hackerrank.DictionariesAndHashMaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;
import java.io.IOException;

public class Anagrams {

    public static Boolean isAnagram(String s1, String s2) {
        int[] charAr = new int[26];

        if (s1.length() != s2.length()) return false;

        for(int i=0; i<26; i++) charAr[i] = 0;

        for (char c : s1.toCharArray()) {
            int val = Character.getNumericValue(c) - Character.getNumericValue('a');
            charAr[val]++;
        }

        for (char c : s2.toCharArray()) {
            int val = Character.getNumericValue(c) - Character.getNumericValue('a');
            charAr[val]--;
            if (charAr[val] < 0) return false;
        }

        for (int i=0; i<26; i++) {
            if (charAr[i] > 0) return false;
        }

        return true;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();
                String s2 = bufferedReader.readLine();

                Boolean result = Anagrams.isAnagram(s1, s2);

                System.out.println("Result is " + result);
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();

    }

}

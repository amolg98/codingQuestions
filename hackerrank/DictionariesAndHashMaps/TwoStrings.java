package hackerrank.DictionariesAndHashMaps;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// import java.io.FileWriter;
import java.util.stream.IntStream;
import java.io.IOException;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {

        int[] charArr = new int[26];

        for (char s : s1.toCharArray()) {
            int val = Character.getNumericValue(s) - Character.getNumericValue('a');
            charArr[val]++;
        }

        for (char c : s2.toCharArray()) {
            int val = Character.getNumericValue(c) - Character.getNumericValue('a');
            if (charArr[val] > 0) {
                return new String("YES"); 
            }
        }

        return new String("NO");

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"))); 
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = TwoStrings.twoStrings(s1, s2);

                System.out.println(result);
                // bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

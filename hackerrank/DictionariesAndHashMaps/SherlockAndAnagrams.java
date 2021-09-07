package hackerrank.DictionariesAndHashMaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;
import java.io.IOException;

public class SherlockAndAnagrams {
    
    public static int sherlockAndAnagrams (String s) {
        return 0;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferReader.readLine();
                System.out.println(SherlockAndAnagrams.sherlockAndAnagrams(s));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        });

        bufferReader.close();
        bufferWriter.close();
    }
}
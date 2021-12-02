package hackerrank.Sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarkAndToys {
    
    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
    // Write your code here
    
        List<Integer> result = new ArrayList<>();
        Collections.sort(prices);
        
        for (int i=0; i<prices.size(); i++) {
            k = k - prices.get(i);
            if (k > 0) {
                result.add(prices.get(i));
            } else {
                break;
            }
        }
        
        return result.size();
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = MarkAndToys.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

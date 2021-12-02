package Extra.AN_SEA;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_first {

    public static int maxTrailing(List<Integer> levels) {
        int minReading = levels.get(0);
        int maxTrailingRecord = -1;
        int currMaxTrailingRecord = -1;
        
        if (levels == null || levels.size() == 0) return -1;
        
        for (int i=1; i<levels.size(); i++) {
            if (levels.get(i) < minReading) {
                minReading = levels.get(i);
            } else {
                currMaxTrailingRecord = levels.get(i) - minReading;
                if(currMaxTrailingRecord > maxTrailingRecord) {
                    maxTrailingRecord = currMaxTrailingRecord;
                }
            }
        }
        
        // Note: If our minReading still reads the first value then no subsequent value was greater than 
        // our minReading so return -1
        return (minReading == levels.get(0))? -1 : maxTrailingRecord;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int levelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> levels = IntStream.range(0, levelsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int result = Solution_first.maxTrailing(levels);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

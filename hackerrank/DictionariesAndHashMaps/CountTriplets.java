package hackerrank.DictionariesAndHashMaps;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountTriplets {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        int result = 0;
        Set<Long> setArr = new HashSet<>();
        Map<Long, Integer> mapArr = new HashMap<>();
        for (Long l: arr) {
            mapArr.put(l, mapArr.getOrDefault(l, 0)+1);
        }
        
        for (Long i: arr) {
            if (!setArr.contains(i)) {
                result += (mapArr.getOrDefault(i, 0) * mapArr.getOrDefault(i*r, 0) * mapArr.getOrDefault(i*r*r, 0));
                setArr.add(i);    
            }
        }
        
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        // int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(Collectors.toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

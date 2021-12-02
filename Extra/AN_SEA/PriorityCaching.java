package Extra.AN_SEA;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class PriorityCaching {
    /*
     * Complete the 'cacheContents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY callLogs as parameter.
     */

    public static List<Integer> cacheContents(List<List<Integer>> callLogs) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        
        int maxTime = 0;
        
        int currTimeStamp = 0;
        int currItemId = 0;
        
        // Map<ItemId, Map<TimeStamp, count>>
        Map<Integer, Map<Integer, Integer>> timeStampMap = new HashMap<>();
                
        for (List<Integer> l: callLogs) {
            currTimeStamp = l.get(0);
            currItemId = l.get(1);
            
            // Create a Map for each itemId with timeStamp as key and its occurences as count
            Map<Integer, Integer> currItemMap = timeStampMap.getOrDefault(currItemId, new HashMap<>());
            
            // If a timestamp for a current item id is existing increase its count
            currItemMap.put(currTimeStamp, currItemMap.getOrDefault(currTimeStamp, 0)+1);
            timeStampMap.put(currItemId, currItemMap);
            
            // Keep track of maximum time in seconds elapsed
            if (currTimeStamp > maxTime) {
                maxTime = currTimeStamp;
            }
        }
        
        for (Map.Entry<Integer, Map<Integer, Integer>> entry: timeStampMap.entrySet()) {
            cacheUpdate(entry.getKey(), entry.getValue(), maxTime, result);
        }
        
        if (result.size() == 0) result.add(-1);
        return result;
        
    }
    
    public static void cacheUpdate(int itemId, Map<Integer, Integer> itemMap, int maxTime, List<Integer> result) {
        int minPriority = 0;
        int currPriority = 0;
        int decPriority = -1;
        int incPriority = 2;
        
        int cacheMoveInPriority = 5;
        int cahceMoveOutPriority = 3;

        // Calculate priority for current itemId at the end of max time
        for (int i=1; i<=maxTime; i++) {
            if (itemMap.containsKey(i)) {
                // increase priority of item by 2 * no of items accessed in this second
                currPriority += incPriority * itemMap.get(i);
            } else {
                // Reduce current Priority by 1 if not accessed in this second
                currPriority += decPriority;
                if ( currPriority < minPriority ) currPriority = minPriority;
            }
            // Add the itemId to cache list if the priority increases by 5
            if (currPriority > cacheMoveInPriority) {
                if (!result.contains(itemId)) result.add(itemId);
            } 
            
            // If the priority of the current itemId is less than or equal to 3
            // remove it from cache list if its present
            if ( (currPriority <= cahceMoveOutPriority) && (result.contains(itemId)) ) {
                // Need to type cast as I am using Integer as an Object
                // otherwise this operation was removing the value from the index
                result.remove((Object)itemId);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));        
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        int callLogsRows = Integer.parseInt(bufferedReader.readLine().trim());
        // int callLogsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> callLogs = new ArrayList<>();

        IntStream.range(0, callLogsRows).forEach(i -> {
            try {
                callLogs.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
                // System.out.println(callLogs.size());
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = PriorityCaching.cacheContents(callLogs);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}

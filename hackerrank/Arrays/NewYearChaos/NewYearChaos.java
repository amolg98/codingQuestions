

import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Result {
    public static void minimumBribes(List<Integer> q) {
        int minBribes = 0;
        
        for (int i=0 ; i<q.size(); i++) {
            if (q.get(i) == (i+1)) { 
                continue;
            } else if (q.get(i) > (i+1+2)) {
                System.out.println("Too chaotic");
                return;
            } else {
                int bribe = (q.get(i) - (i+1));
                if ((bribe == 2) && (q.get(i+1) > q.get(i+2))) {
                    bribe += 1;
                }
                // i = i + bribe;
                minBribes += bribe;
            }
        }
        System.out.println(minBribes);

    }
}


public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> q = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qTemp[i]);
                q.add(qItem);
            }

            Result.minimumBribes(q);
        }
        bufferedReader.close();
    }
}
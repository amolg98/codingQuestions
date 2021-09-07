package Extra;

public class PPExtra {

    
    private static int getNumOfAlerts(int[] numCalls, int alertThreshold, int precedingMinutes) {
        int[] preSum = new int[numCalls.length + 1];
        int res = 0;
        for(int i=1;i<preSum.length;i++) {
            preSum[i] = numCalls[i-1] + preSum[i-1];
        }
        for(int i=precedingMinutes;i<=numCalls.length;i++) {
            if((Math.ceil( preSum[i] - preSum[i-precedingMinutes]) / (float) precedingMinutes) > alertThreshold)
                res++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] numCalls = {0,11,10,10,7};
        int alertThreshold = 10, precedingMinutes = 3;
        System.out.println(getNumOfAlerts(numCalls, alertThreshold, precedingMinutes));

        int[] numCalls2 = {2,2,2,2,5,5,5,8};
        alertThreshold = 4;
        precedingMinutes = 3;
        System.out.println(getNumOfAlerts(numCalls2, alertThreshold, precedingMinutes));
    }
}

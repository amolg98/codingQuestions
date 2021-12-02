package Companies;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Beacon {

    public static int numParks(List<List<Integer>> city) {
        int result = 0;
        if (city == null || city.size() == 0) return result;
        int rowLen = city.size();
        int colLen = city.get(0).size();
        int[][] arrCity = new int[rowLen][colLen];

        for (int i=0; i<rowLen; i++) {
            List<Integer> l = city.get(i);
            for (int j=0; j<colLen; j++) {
                arrCity[i][j] = l.get(j);
            }
        }

        for (int i=0; i<arrCity.length; i++) {
            for (int j=0; j<arrCity[0].length; j++) {
                if (arrCity[i][j] == 1) {
                    result++;
                    markAreaVisited(arrCity, i, j, rowLen, colLen);
                }
            }
        }
        return result;
    }

    public static void markAreaVisited(int[][] arrCity, int i, int j, int m, int n) {
        if (i<0 || i>=m || j<0 || j>=n || arrCity[i][j] != 1) {
            return;
        }
        arrCity[i][j] = -1;

        markAreaVisited(arrCity, i+1, j, m, n);
        markAreaVisited(arrCity, i-1, j, m, n);
        markAreaVisited(arrCity, i, j+1, m, n);
        markAreaVisited(arrCity, i, j-1, m, n);
    }

    public static void main(String[] args) {

        // List<Integer> stockPrices = new ArrayList<>();

        // stockPrices.add(10);
        // stockPrices.add(32);
        // stockPrices.add(45);
        // stockPrices.add(56);
        // stockPrices.add(24);
        // stockPrices.add(87);

        // // [10, 32, 45, 56, 24, 87]
        // // [0, 22, 35, 46, 14, 77]
        
        // int maxProfit = 0;
        // int currVal = 0;
        // // for (int i=1; i<stockPrices.size(); i++) {
        // //     for (int j=0; j<i; j++) {
        // //         currVal = Math.max(stockPrices.get(i) - stockPrices.get(j), 0);
        // //         if (currVal > maxProfit) 
        // //             maxProfit = currVal;
        // //     }
        // // }

        // int minPrice = stockPrices.get(0);
        // for (int value: stockPrices) {
        //     if (value < minPrice) {
        //         minPrice = value;
        //         continue;
        //     }
        //     maxProfit = Math.max(value - minPrice, maxProfit);
        // }

        // System.out.println(maxProfit);

        // // int maxProfit = stockPrices.get(0);
        // // for (int i=0; i<stockPrices.size(); i++) {
        // //     if (maxProfit > Math.max(0, ));
        // // }

        List<List<Integer>> city = new ArrayList<>();

        city.add(Arrays.asList(1,1,0,0,1,0));
        city.add(Arrays.asList(0,0,0,1,1,0));
        city.add(Arrays.asList(1,1,1,0,1,1));
        city.add(Arrays.asList(1,0,0,0,0,0));

        for (List<Integer> l: city) {
            for(Integer i: l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println(numParks(city));


    }
}

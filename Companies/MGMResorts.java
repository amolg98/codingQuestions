package Companies;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;

class Pair {
    int id;
    float price;

    Pair(int id, float price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{ partitionKey: " + this.id + ", totalPrice: " + this.price + " }";
    }
}

public class MGMResorts {

    /**
     * A database is partitioned by the id field (a positive non-zero integer) mod n, where n is a configurable positive non-zero integer.
    A batch of items is retrieved from the database. Given this data as a list/array of objects in the format: {id: int, price: float},
    create a list/array of the sum of prices from each partition where the objects in this list are in this format:
    { partitionKey: int, totalPrice: float }.

    Example: Given
    [{id: 20, price: 10.0}, {id: 21, price: 1.39}, {id: 4, price: 30.11}, {id: 11, price: 4.68}]
    where n = 2, the result should be:
    [{partitionKey: 0, totalPrice: 40.11}, {partitionKey: 1, totalPrice: 6.07}].
    If n = 3 then the result should be:
    [{partitionKey: 0, totalPrice: 1.39 }, {partitionKey: 1, totalPrice: 30.11 }, {partitionKey: 2, totalPrice: 14.68 }]
     * @param args
     */

    

    public static List<Pair> totalPrice(List<Pair> inputList, int n) {
        List<Pair> result = new ArrayList<>();
        Map<Integer, Float> map = new HashMap<>();
        int modValue = 0;
        for (int i=0; i<inputList.size(); i++) {
            modValue = inputList.get(i).id % n;
            
            map.put(modValue, map.getOrDefault(modValue, 0f) + inputList.get(i).price);

        }
        

        for (Map.Entry<Integer, Float> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            result.add(p);
            // System.out.println("{ partitionKey: " + entry.getKey() + ", totalPrice: " + entry.getValue() + " }");
        }

        return result;

    }

    public static void main(String[] args) {
        
        Pair pair = new Pair(20, 10.0f);
        Pair pair2 = new Pair(21, 1.39f);
        Pair pair3 = new Pair(4, 30.11f);
        Pair pair4 = new Pair(11, 4.68f);
        List<Pair> priceList = new ArrayList<>();
        priceList.add(pair);
        priceList.add(pair2);
        priceList.add(pair3);
        priceList.add(pair4);

        List<Pair> result = null;
        result = totalPrice(priceList, 2);
        System.out.println(result);

        result = totalPrice(priceList, 3);
        System.out.println(result);

    }
}

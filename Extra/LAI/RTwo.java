package Extra.LAI;

    /*
 * Click `Run` to execute the snippet below!
 */

// import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
2: ['A', 'B', 'C'],
3: ['D', 'E', 'F'],
4: ['G', 'H', 'I'],
5: ['J', 'K', 'L'],
6: ['M', 'N', 'O'],
7: ['P', 'Q', 'R', 'S'],
8: ['T', 'U', 'V'],
9: ['W', 'X', 'Y', 'Z'],

23 → ['AD', 'AE', 'AF', 'BD', 'BE', 'BF', 'CD', 'CE', 'CF'] 
 */

public class RTwo {

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());
    Map<Character, List<String>> map = new HashMap<>();
    
    List<String> l = Arrays.asList("A", "B","C");
    map.put('2', l);
    
    l = Arrays.asList("D", "E","F");
    map.put('3', l);
    
    String value = "23";
    
    List<String> s = null;
    List<List<String>> res = new ArrayList<>();
    
    for (char c: value.toCharArray()) {
      s =  map.get(c);
      res.add(s);
    }
    
    
    List<String> result = new ArrayList<>();
    
    for (int i=0; i<res.size(); i++) {
      for (int j=i+1; j<res.size(); j++) {
        List<String> l1 = res.get(i);
        List<String> l2 = res.get(j);
        for (int k=0; k<l1.size(); k++) {
          for (int m=0; m<l2.size(); m++) {
            result.add(l1.get(k) + l2.get(m)); 
          }
        }
      }
    }
    
    for (String str: result) {
       System.out.println(str);
    }
    
    

    for (String string : strings) {
      System.out.println(string);
    }
    
    
  }
}

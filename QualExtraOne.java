// # ----------------------------------------------- 
// # Coding Problem: "Pecan Pie"
// # ----------------------------------------------- 

// '''
// Write a function which takes a string and returns an array of noun-chunks (contiguous sequences of nouns)

// Example:
// "I love pecan pie and ice cream" -> ["I", "pecan pie", "ice cream"]
//  N  V    N    N   O   N    N

// You are given a magic "partOfSpeech" function which accepts a word as input, and returns a part of speech.
// For this problem, we will assume there are only four kinds of words: Noun, Verb, Adjective, or Other.

// Examples:
// partOfSpeech("fresh") -> "A"
// partOfSpeech("pecan") -> "N"
// partOfSpeech("love") -> "V"
// partOfSpeech("and") -> "O"

/**

String I 
String 
*/
// '''
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QualExtraOne {
    
    public static List<String> nounChunks(String inputString) {
        
        if (inputString.length() == 0) return null;
        
        List<String> inputList = Stream.of(inputString.split(" ")).collect(Collectors.toList());
        
        // System.out.println(inputList);
        
        List<String> result = new ArrayList<>();
        boolean f = false;
        String currStr = "";
        for (int i=0; i<inputList.size(); i++) {
            if (partOfSpeech(inputList.get(i)).equals("N") ) {
                if (!f) {
                    currStr = inputList.get(i);
                    f = true;
                } else {
                    currStr = currStr + " " + inputList.get(i);
                }
            } else {
                if (currStr.length() > 0) {
                    result.add(currStr);
                }
                currStr = "";
                f = false;
            }
        }
        
        if (currStr.length() > 0) {
            result.add(currStr);
        }
        
        return result;
    }
    
    public static String partOfSpeech(String word) {
        Map<String, String> wordToPartOfSpeech = new HashMap<String, String>();

        // Nouns
        wordToPartOfSpeech.put("I", "N");
        wordToPartOfSpeech.put("pecan", "N");
        wordToPartOfSpeech.put("pie", "N");
        wordToPartOfSpeech.put("ice", "N");
        wordToPartOfSpeech.put("cream", "N");

        // Verbs
        wordToPartOfSpeech.put("love", "V");

        // Adjectives
        wordToPartOfSpeech.put("cold", "A");
        wordToPartOfSpeech.put("fresh", "A");

        // Other
        wordToPartOfSpeech.put("and", "O");
        wordToPartOfSpeech.put("Hello", "O");
        wordToPartOfSpeech.put("World", "O");

        return wordToPartOfSpeech.get(word);
    }

   

 public static void main(String[] args) {
        
        String str1 = "I love pecan pie and ice cream";
        
        List<String> result = Arrays.asList("I", "pecan pie", "ice cream");
        
        System.out.println(nounChunks(str1));
        System.out.println(nounChunks("") == null);
        System.out.println(nounChunks("Hello World"));
        System.out.println(nounChunks("I pecan pie ice cream"));
        
        
        // System.out.println(sum);
   }
}

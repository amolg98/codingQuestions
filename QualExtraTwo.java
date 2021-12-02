import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/* 
~~MASTERMIND~~
A spy has broken into the lair of a diabolical villain, Mastermind, and is trying to disarm the doomsday device by guessing the deactivation code. Mastermind has said he'll give the Spy 10 guesses to deactivation code, otherwise the device will go off.
Players: 2, Mastermind and Spy
Setup: The Mastermind, chooses a 5 digit number and enters it into the Doomsday device
Gameplay:A round consisted of two steps:
1: The Spy enters a guess at what the deactivation code is.
2: The Doomsday device gives feedback about the accuracy of the guess. Feedback will be given for each digit. The feedback is either:
* Right digit, right place, r 
* Digit is used in the answer but is in the incorrect place, i 
* Digit is not used in the answer, n
Win conditions:
Mastermind victory:If the Spy does not guess the deactivation code by the end of the 10th round, the device goes off and Mastermind wins!
Spy victory:If the Spy is able to guess they deactivation code before the Mastermind wins, they deactivate the bomb, save the world, and win!
~~~

Write a program such that two players, the Mastermind and a Spy, can play this game
*/

public class QualExtraTwo {

    static int[] masterMindNumber = new int[] {3, 5, 7, 2, 0};
    static Map<Integer, Integer> map = new HashMap<>();    
    {
        for (int i: masterMindNumber) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
        }
    }
    
    // 
    public static char doomsDayDeviceFeedback(int n, int index) {

        if (masterMindNumber[index] == n) {
            return 'r';
        }
        
        // for (int i=0; i<5; i++) {
        //     if (i == index)
        //         continue;
        //     if (masterMindNumber[i] == n)
        //         return 'i';
        // }
        if (map.containsKey(n))
            return 'i';
        
        return 'n';
    }
    
    public static boolean tryCode(int x) {
        int currIndex = 0;
        int val = x;
        String s = "";
        
        for (int j=0; j<5; j++) {
            int currDigit = val % 10;
            val = val / 10;        
            
            char c = doomsDayDeviceFeedback(currDigit, 4 - currIndex);
            s = c + s;
            currIndex++;
        }
        
        System.out.println(s);
        if (s.equals("rrrrr")) {
            System.out.println("Bomb Defused");
            return true;
        }
        
        return false;
    } 
    

 public static void main(String[] args) {
    
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    
    int x = 0;

    String s = "";
    boolean flag = false;
        
    for (int i= 0 ; i< 10; i++) {
        // x = user input;
        
        // x = 42123; // Bomb exploded // ninri
        // x = 35481; // Bomb exploded // rrnnn
        x  = 35720; // Bomb defused // rrrrr
        if (tryCode(x)) {
            flag = true;
        }
    }
    
    if (!flag) System.out.println("Bomb exploded");
    
   }
}

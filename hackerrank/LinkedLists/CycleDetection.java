package hackerrank.LinkedLists;

// import java.util.List;
// import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
// import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    SinglyLinkedListNode() {}
    SinglyLinkedListNode(int data) { this.data = data; }
}

public class CycleDetection {

    /**
     * Working solution
     * @param head
     * @return
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode ptr = head, nextPtr = null;
        if (ptr != null) 
            nextPtr = head.next;

        while (nextPtr != null && nextPtr.next != null) {
            if (ptr == nextPtr) return true;
            ptr = ptr.next;
            nextPtr = nextPtr.next.next;
        }
    
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            // int index = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            // SinglyLinkedList llist = new SinglyLinkedList();

            // int llistCount = scanner.nextInt();
            // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            // for (int i = 0; i < llistCount; i++) {
            //     int llistItem = scanner.nextInt();
            //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            //     llist.insertNode(llistItem);
            // }
          
          	// SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
            // SinglyLinkedListNode temp = llist.head;

            // for (int i = 0; i < llistCount; i++) {
            //     if (i == index) {
            //         extra = temp;
            //     }

            //     if (i != llistCount-1) {
            //         temp = temp.next;
            //     }
            // }
      
      		// temp.next = extra;

            boolean result = true;

            bufferedWriter.write(String.valueOf(result ? 1 : 0));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
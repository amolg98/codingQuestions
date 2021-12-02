package Companies;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Node {
    String lastName;
    String firstName;
    Node father;
    Node mother;
    Node spouse;
    List<Node> children;
    Date dob;

    // All getter setters

    // Asked to add by interviewer
    public Node getGrandFather() {

        return this.father.father;
    }
  
}

class FamilyTree {
    Node node;
    
    public static List<Node> getCousins(Node node) {
        List<Node> result = new ArrayList<>();  
        if (node == null)
            return result;
        
        Node fatherNode = node.father;
        Node motherNode = node.mother;
        
        
        Node grandMotherNode = motherNode.mother;
        
        List<Node> fatherSiblings; 
        if (fatherNode != null) {
            Node grandFatherNode = fatherNode.father;
            if (grandFatherNode != null) {
                fatherSiblings = grandFatherNode.children;
                for (Node n: fatherSiblings) {
                    result.addAll(n.children);
                }
            }
        }
            
        List<Node> motherSiblings = grandMotherNode.children;
        
        
        
        for (Node n: motherSiblings) {
            result.addAll(n.children);
        }
        
        return result;
    }
}

/**
  fatherNode -> grandFather -> list of his children , motherNode -> grandFather -> list of children
  
*/

public class GS {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());
    
        for (String string : strings) {
          System.out.println(string);
        }
      }  
}



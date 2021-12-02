package hackerrank.Trees;

import java.util.Scanner;

class Node {
	int val;
	Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class HeightOfABinaryTree {
    
	public static int height(Node root) {
        // Write your code here.
        int lH = totalHeight(root.left);
        int rH = totalHeight(root.right);

        return lH >= rH ? lH : rH;
    }

    public static int totalHeight(Node root) {
        int leftHeight = 0, rightHeight = 0;
        if (root == null)
            return 0;
        
        if(root.left != null) {
            leftHeight = totalHeight(root.left);
        }
        if (root.right != null) {
            rightHeight = totalHeight(root.right);
        }
        // System.out.println(root.val + " " + leftHeight + " " + rightHeight);
        return leftHeight >= rightHeight ? leftHeight + 1: rightHeight + 1;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.val) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}

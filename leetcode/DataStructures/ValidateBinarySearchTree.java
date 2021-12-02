package leetcode.DataStructures;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// import java.util.List;
// import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ValidateBinarySearchTree {

    /**
     * First approach O(n) but still takes longer as we need 
     * to go through list so another O(n) overall O(2n) ~ O(n)
     */
     
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null)
    //         return true;
        
    //     List<Integer> result = new ArrayList<>();
    //     isValidBST(root, result);
        
    //     for(int i=1; i<result.size(); i++) {
    //         if (result.get(i) <= result.get(i-1)) return false;
    //     }

    //     return true;
    // }

    // public void isValidBST(TreeNode node, List<Integer> l) {
    //     if (node == null) return;

    //     // In-Order sequence
    //     if (node.left != null) isValidBST(node.left, l);
    //     l.add(node.val);
    //     if (node.right != null) isValidBST(node.right, l);
    // }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) 
            return true;

        if ((root.val <= min) || (root.val >= max)) 
            return false;

        return (isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max));

    }

    public static void main(String[] args) {
        
    }
}

package Extra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Definition for a binary tree node.
class TreeNode { 
    int val; 
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; 
        this.left = left;
        this.right = right;
    }
} 

public class Test {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        getTreeList(root1, l1);
        getTreeList(root2, l2);

        for (int i=0; i<l1.size(); i++) {
            
        }

        return root1;
        
    }
    
    public void getTreeList(TreeNode root, List<Integer> l) {
        if (root == null)
            return;
        PriorityQueue<TreeNode> p = new PriorityQueue<>();
        p.add(root);
        
        while (!p.isEmpty()) {
            TreeNode t = p.peek();
            l.add(t.val);
            if (root.left != null) 
                p.add(root.left);
            
            if (root.right != null) p.add(root.right);
        }

    }

    public static void main(String[] args) {
        
    }
}
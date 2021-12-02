package hackerrank.Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.io.IOException;

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

class Result {

    /**
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        TreeNode head = new TreeNode(1);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        for (List<Integer> l: indexes) {
            TreeNode curr = queue.poll();

            if (l.get(0) != -1) {
                curr.left = new TreeNode(l.get(0));
                queue.offer(curr.left);
            }
            if (l.get(1) != -1) {
                curr.right = new TreeNode(l.get(1));
                queue.offer(curr.right);
            }
        }

        for (int i: queries) {
            swapNode(head, 0, i);
            List<Integer> currList = new ArrayList<>();
            printInOrder(head, currList);
            result.add(currList);
        }

        return result;
    }

    public static void swapNode(TreeNode root, int height, int i) {
        if (root == null)
            return;
        
        height = height + 1;
        if (height % i == 0) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        if (root.left != null) swapNode(root.left, height, i);
        if (root.right != null) swapNode(root.right, height, i);
    } 


    public static void printInOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
            
        if (root.left != null) printInOrder(root.left, result);
        result.add(root.val);
        if (root.right != null) printInOrder(root.right, result);
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.val) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}

public class SwapNodes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "))
            )
            .map(r -> r + "\n")
            .collect(Collectors.toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

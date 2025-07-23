import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreePathProblems {

    public static void findAllPaths(Node root, List<Integer> path, List<List<Integer>> all) {
        if (root == null) return;
        path.add(root.value);
        if (root.left == null && root.right == null) {
            all.add(new ArrayList<>(path));
        } else {
            findAllPaths(root.left, path, all);
            findAllPaths(root.right, path, all);
        }
        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(Node root, int target, int current) {
        if (root == null) return false;
        current += root.value;
        if (root.left == null && root.right == null) return current == target;
        return hasPathSum(root.left, target, current) || hasPathSum(root.right, target, current);
    }

    public static int maxPathSum(Node root, int sum) {
        if (root == null) return Integer.MIN_VALUE;
        sum += root.value;
        if (root.left == null && root.right == null) return sum;
        return Math.max(maxPathSum(root.left, sum), maxPathSum(root.right, sum));
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(10);

        List<List<Integer>> all = new ArrayList<>();
        findAllPaths(root, new ArrayList<>(), all);
        System.out.println("所有根到葉路徑: " + all);

        System.out.println("是否有路徑總和為 10: " + hasPathSum(root, 10, 0));
        System.out.println("最大路徑總和: " + maxPathSum(root, 0));
    }
}

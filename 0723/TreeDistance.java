import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreeDistance {

    public static int findDistance(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        int d1 = depth(lca, a, 0);
        int d2 = depth(lca, b, 0);
        return d1 + d2;
    }

    public static Node findLCA(Node root, int a, int b) {
        if (root == null) return null;
        if (root.value == a || root.value == b) return root;
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static int depth(Node root, int val, int d) {
        if (root == null) return -1;
        if (root.value == val) return d;
        int left = depth(root.left, val, d + 1);
        if (left != -1) return left;
        return depth(root.right, val, d + 1);
    }

    static int diameter = 0;

    public static int findDiameter(Node root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    public static int height(Node node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void nodesAtDistance(Node root, int k, List<Integer> result) {
        if (root == null) return;
        if (k == 0) {
            result.add(root.value);
            return;
        }
        nodesAtDistance(root.left, k - 1, result);
        nodesAtDistance(root.right, k - 1, result);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int dist = findDistance(root, 4, 6);
        System.out.println("節點 4 到 6 的距離: " + dist);

        int dia = findDiameter(root);
        System.out.println("樹的直徑: " + dia);

        List<Integer> result = new ArrayList<>();
        nodesAtDistance(root, 2, result);
        System.out.println("距離 root 為 2 的節點: " + result);
    }
}

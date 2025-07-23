import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class BSTRangeQuery {

    public static void insert(Node root, int value) {
        if (value < root.value) {
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        } else {
            if (root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        }
    }

    public static void rangeQuery(Node root, int min, int max, ArrayList<Integer> result) {
        if (root == null) return;
        if (root.value > min) rangeQuery(root.left, min, max, result);
        if (root.value >= min && root.value <= max) result.add(root.value);
        if (root.value < max) rangeQuery(root.right, min, max, result);
    }

    public static void main(String[] args) {
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        Node root = new Node(values[0]);
        for (int i = 1; i < values.length; i++) {
            insert(root, values[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        rangeQuery(root, 12, 27, result);
        System.out.println(result);
    }
}

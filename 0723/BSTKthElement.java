class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class BSTKthElement {

    static int count = 0;
    static int result = -1;

    public static void findKth(Node root, int k) {
        if (root == null) return;
        findKth(root.left, k);
        count++;
        if (count == k) {
            result = root.value;
            return;
        }
        findKth(root.right, k);
    }

    public static void main(String[] args) {
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        Node root = new Node(values[0]);
        for (int i = 1; i < values.length; i++) {
            insert(root, values[i]);
        }

        int k = 3;
        count = 0;
        result = -1;
        findKth(root, k);
        System.out.println("第 " + k + " 小的元素為: " + result);
    }

    public static void insert(Node root, int value) {
        if (value < root.value) {
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        } else {
            if (root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        }
    }
}

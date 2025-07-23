class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreeStatistics {

    public static int sum(Node root) {
        if (root == null) return 0;
        return root.value + sum(root.left) + sum(root.right);
    }

    public static int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.value, Math.max(max(root.left), max(root.right)));
    }

    public static int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.value, Math.min(min(root.left), min(root.right)));
    }

    public static int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(25);

        System.out.println("總和: " + sum(root));
        System.out.println("最大值: " + max(root));
        System.out.println("最小值: " + min(root));
        System.out.println("葉節點數量: " + countLeaves(root));
        System.out.println("樹的高度: " + height(root));
    }
}

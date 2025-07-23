class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class BSTBalance {

    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    public static int checkHeight(Node node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    public static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static Node findMostUnbalanced(Node root) {
        if (root == null) return null;
        Node left = findMostUnbalanced(root.left);
        Node right = findMostUnbalanced(root.right);
        Node worst = root;

        if (left != null && Math.abs(balanceFactor(left)) > Math.abs(balanceFactor(worst)))
            worst = left;
        if (right != null && Math.abs(balanceFactor(right)) > Math.abs(balanceFactor(worst)))
            worst = right;

        return worst;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(15);

        System.out.println("是否為平衡樹: " + isBalanced(root));
        System.out.println("根節點平衡因子: " + balanceFactor(root));

        Node worst = findMostUnbalanced(root);
        System.out.println("最不平衡節點: " + worst.value + "（平衡因子=" + balanceFactor(worst) + "）");
    }
}

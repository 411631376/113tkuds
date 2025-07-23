class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreeComparison {

    public static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.value != b.value) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static boolean isSubtree(Node root, Node sub) {
        if (root == null) return false;
        if (isSameTree(root, sub)) return true;
        return isSubtree(root.left, sub) || isSubtree(root.right, sub);
    }

    public static Node findLCS(Node a, Node b) {
        if (a == null || b == null) return null;
        if (isSameTree(a, b)) return a;

        Node left = findLCS(a.left, b);
        Node right = findLCS(a.right, b);
        return left != null ? left : right;
    }

    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.value + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        Node sub = new Node(2);

        System.out.println("完全相同: " + isSameTree(root1, root2));
        System.out.println("是否為子樹: " + isSubtree(root1, sub));

        Node lcs = findLCS(root1, root2);
        System.out.print("最大公共子樹中序: ");
        printInorder(lcs);
        System.out.println();
    }
}

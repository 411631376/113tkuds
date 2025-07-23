class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreeMirror {

    public static boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.value == t2.value) &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }

    public static void mirror(Node root) {
        if (root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public static boolean areMirrors(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.value == b.value) &&
               areMirrors(a.left, b.right) &&
               areMirrors(a.right, b.left);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(2);
        root1.left.left = new Node(3);
        root1.left.right = new Node(4);
        root1.right.left = new Node(4);
        root1.right.right = new Node(3);

        System.out.println("是否對稱: " + isSymmetric(root1));

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        mirror(root2);

        Node root3 = new Node(1);
        root3.left = new Node(3);
        root3.right = new Node(2);

        System.out.println("是否為互為鏡像: " + areMirrors(root2, root3));
    }
}

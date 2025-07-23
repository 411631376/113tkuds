import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class BSTConversion {

    public static void bstToList(Node root, List<Integer> list) {
        if (root == null) return;
        bstToList(root.left, list);
        list.add(root.value);
        bstToList(root.right, list);
    }

    public static Node sortedArrayToBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(list.get(mid));
        node.left = sortedArrayToBST(list, start, mid - 1);
        node.right = sortedArrayToBST(list, mid + 1, end);
        return node;
    }

    public static void convertToGreaterSumTree(Node root, int[] sum) {
        if (root == null) return;
        convertToGreaterSumTree(root.right, sum);
        sum[0] += root.value;
        root.value = sum[0];
        convertToGreaterSumTree(root.left, sum);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(8);

        List<Integer> list = new ArrayList<>();
        bstToList(root, list);
        System.out.println("BST to List: " + list);

        Node balanced = sortedArrayToBST(list, 0, list.size() - 1);
        System.out.print("轉為平衡BST後中序：");
        inorder(balanced);
        System.out.println();

        int[] sum = {0};
        convertToGreaterSumTree(balanced, sum);
        System.out.print("轉換為Greater Sum Tree後中序：");
        inorder(balanced);
        System.out.println();
    }
}

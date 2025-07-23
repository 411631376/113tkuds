import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class BSTValidation {

    public static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return validate(node.left, min, node.value) &&
               validate(node.right, node.value, max);
    }

    public static void findInvalidNodes(Node node, List<Integer> invalid, long min, long max) {
        if (node == null) return;
        if (node.value <= min || node.value >= max) {
            invalid.add(node.value);
        }
        findInvalidNodes(node.left, invalid, min, node.value);
        findInvalidNodes(node.right, invalid, node.value, max);
    }

    public static int minRemovalToBST(Node node, List<Integer> list) {
        if (node == null) return 0;
        if (isValidBST(node)) return 0;
        list.clear();
        findInvalidNodes(node, list, Long.MIN_VALUE, Long.MAX_VALUE);
        return list.size();
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);  // 錯誤：應 >10

        System.out.println("是否為合法 BST: " + isValidBST(root));

        List<Integer> bad = new ArrayList<>();
        findInvalidNodes(root, bad, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("違規節點: " + bad);

        int toRemove = minRemovalToBST(root, new ArrayList<>());
        System.out.println("最少需刪除節點數: " + toRemove);
    }
}

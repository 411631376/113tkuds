import java.util.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreeLevelTraversal {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.value);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void zigzagTraversal(Node root) {
        List<List<Integer>> levels = levelOrder(root);
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);
            if (i % 2 == 1) Collections.reverse(level);
            System.out.println(level);
        }
    }

    public static void printLastInEachLevel(Node root) {
        List<List<Integer>> levels = levelOrder(root);
        for (List<Integer> level : levels) {
            System.out.println(level.get(level.size() - 1));
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> levelLists = levelOrder(root);
        System.out.println("每層分開存入 List：");
        for (List<Integer> level : levelLists) {
            System.out.println(level);
        }

        System.out.println("Zigzag 層序遍歷：");
        zigzagTraversal(root);

        System.out.println("每層最後一個節點：");
        printLastInEachLevel(root);
    }
}

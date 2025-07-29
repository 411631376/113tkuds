import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");

        if (nodes.length == 0 || nodes[0].equals("-1")) {
            System.out.println("LeftView:");
            return;
        }

        TreeNode root = buildTree(nodes);
        printLeftView(root);
    }


    public static TreeNode buildTree(String[] nodes) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode current = q.poll();
            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(current.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printLeftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        System.out.print("LeftView:");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) System.out.print(" " + node.val); 
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        System.out.println();
    }
}


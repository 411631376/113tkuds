import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] level = sc.nextLine().split(" ");
        String[] lr = sc.nextLine().split(" ");
        int L = Integer.parseInt(lr[0]);
        int R = Integer.parseInt(lr[1]);

        TreeNode root = buildTree(level);
        int sum = rangeSumBST(root, L, R);
        System.out.println("Sum: " + sum);
    }

    // 建立 BST (層序建樹，支援 -1 表 null)
    public static TreeNode buildTree(String[] level) {
        if (level.length == 0 || level[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(level[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < level.length) {
            TreeNode curr = queue.poll();
            if (i < level.length && !level[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(level[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < level.length && !level[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(level[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // 中序 + 剪枝
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
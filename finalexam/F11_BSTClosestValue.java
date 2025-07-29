import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] level = sc.nextLine().split(" ");
        double target = Double.parseDouble(sc.nextLine());  // ← 改成 double

        TreeNode root = buildTree(level);
        int closest = findClosest(root, target);
        System.out.println("Closest: " + closest);
    }

 
    public static TreeNode buildTree(String[] level) {
        if (level.length == 0 || level[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(level[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < level.length) {
            TreeNode current = queue.poll();
            if (i < level.length && !level[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(level[i]));
                queue.offer(current.left);
            }
            i++;
            if (i < level.length && !level[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(level[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    
    public static int findClosest(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
                (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }
            root = (target < root.val) ? root.left : root.right;
        }
        return closest;
    }
}


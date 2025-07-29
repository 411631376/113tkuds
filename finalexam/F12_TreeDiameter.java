import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDiameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] level = sc.nextLine().split(" ");

        TreeNode root = buildTree(level);
        getHeight(root);  
        System.out.println("Diameter: " + maxDiameter);
    }

    
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

  
    public static int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        maxDiameter = Math.max(maxDiameter, left + right); 
        return Math.max(left, right) + 1;
    }
}


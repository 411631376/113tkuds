
class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class TreeReconstruction {

    static int preIndex = 0;
    static int postIndex;

    public static Node buildFromPreIn(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        Node root = new Node(preorder[preIndex++]);
        if (inStart == inEnd) return root;
        int index = find(inorder, inStart, inEnd, root.value);
        root.left = buildFromPreIn(preorder, inorder, inStart, index - 1);
        root.right = buildFromPreIn(preorder, inorder, index + 1, inEnd);
        return root;
    }

    public static Node buildFromPostIn(int[] postorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        Node root = new Node(postorder[postIndex--]);
        if (inStart == inEnd) return root;
        int index = find(inorder, inStart, inEnd, root.value);
        root.right = buildFromPostIn(postorder, inorder, index + 1, inEnd);
        root.left = buildFromPostIn(postorder, inorder, inStart, index - 1);
        return root;
    }

    public static int find(int[] arr, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }

    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.value + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder =  {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        preIndex = 0;
        Node fromPreIn = buildFromPreIn(preorder, inorder, 0, inorder.length - 1);
        System.out.print("前序+中序建樹→中序輸出：");
        printInorder(fromPreIn);
        System.out.println();

        postIndex = postorder.length - 1;
        Node fromPostIn = buildFromPostIn(postorder, inorder, 0, inorder.length - 1);
        System.out.print("後序+中序建樹→中序輸出：");
        printInorder(fromPostIn);
        System.out.println();
    }
}

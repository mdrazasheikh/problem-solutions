static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
}

public static void printInOrder(TreeNode root) {
    if (root == null) return;
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
}

void main() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    System.out.print("Before: ");
    printInOrder(root);
    System.out.println();
    invertTree(root);
    System.out.print("After: ");
    printInOrder(root);
    System.out.println();
    // Expected After (inorder): 9 7 6 4 3 2 1
}

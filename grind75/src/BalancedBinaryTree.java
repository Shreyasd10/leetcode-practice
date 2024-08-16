public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if(root == null) return new int[]{1,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1 && (Math.abs(left[1] - right[1]) <= 1));
        int height = 1 + Math.max(left[1],right[1]);

        return new int[]{balanced ? 1 : 0,height};
    }

    public boolean isBalancedV2(TreeNode root){
        if(root == null || root.left == null || root.right == null) return true;
        return height(root) != -1;

    }

    private int height(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = height(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        // Creating a balanced binary tree:
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        // Creating an instance of BalancedBinaryTree
        BalancedBinaryTree tree = new BalancedBinaryTree();

        // Checking if the tree is balanced
        boolean result = tree.isBalanced(root);

        // Printing the result
        System.out.println("Is the binary tree balanced? " + result);
    }
}

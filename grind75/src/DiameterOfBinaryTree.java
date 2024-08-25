public class DiameterOfBinaryTree {
    int max = 0;
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

    public int diameterOfBinaryTree(TreeNode root){
        maxHeight(root);
        return max;
    }

    private int maxHeight(TreeNode root) {
        if(root == null) return 0;

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        max = Math.max(max,left + right);
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {
        // Example tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree diameterCalculator = new DiameterOfBinaryTree();
        int diameter = diameterCalculator.diameterOfBinaryTree(root);

        System.out.println("Diameter of the binary tree: " + diameter);
    }
}

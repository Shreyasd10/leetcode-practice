public class LCA {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if((root == p || root == q )|| (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)){
                return root;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return root;
     }

    // Helper method to insert nodes into the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        LCA tree = new LCA();

        // Create the BST
        TreeNode root = tree.insert(null, 6);
        tree.insert(root, 2);
        tree.insert(root, 8);
        tree.insert(root, 0);
        tree.insert(root, 4);
        tree.insert(root, 7);
        tree.insert(root, 9);
        tree.insert(root, 3);
        tree.insert(root, 5);

        // Find the LCA of nodes 2 and 8
        TreeNode p = root.left;  // Node with value 2
        TreeNode q = root.right; // Node with value 8

        TreeNode lca = tree.lowestCommonAncestor(root, p, q);

        // Print the result
        System.out.println("LCA of nodes " + p.val + " and " + q.val + " is: " + lca.val);
    }
}

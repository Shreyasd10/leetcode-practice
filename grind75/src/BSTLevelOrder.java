import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelOrder {

    public class TreeNode{

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int levelSize = 0;
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            levelSize = queue.size();
            for(int i = 0; i<levelSize; i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(subList);
        }
        return result;
    }
}

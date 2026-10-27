/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // for each level, use a queue to put the unhandled nodes
        while(!queue.isEmpty()){
            int size = queue.size(); // remember the size of this level
            List<Integer> level = new ArrayList<>(); // create subList for this level
            // handle each level
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val); // add to the subList
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            // add sub list to the main list
            res.add(level);
        }
        return res;
    }
}
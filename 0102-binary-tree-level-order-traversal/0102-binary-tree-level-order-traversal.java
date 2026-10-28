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
        queue.offer(root); // first level
        // traverse level by level
        // use a queue to store nodes in every level
        while(!queue.isEmpty()){
            // create a list when travesing every level and put the val in
            List<Integer> list = new ArrayList<>();
            // remember the size of this level before handling it
            int size = queue.size();
            for(int i = 0; i < size; i++){
                // get a node
                TreeNode node = queue.poll();
                // put the val in the list
                list.add(node.val);
                // handle the children
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            // add the list to the res
            res.add(list);
        }
        return res;
    }
}
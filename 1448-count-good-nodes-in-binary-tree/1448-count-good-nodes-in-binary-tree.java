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
    public int goodNodes(TreeNode root) {
        // for every node:
        // record if the children of the node is good and update children's vals as the biggest val from root until here when handing the val
        int res = 0;
        if(root == null) return res;
        // level order
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        res++;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    if(node.val <= node.left.val) res++;
                    node.left.val = Math.max(node.val, node.left.val);
                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(node.val <= node.right.val) res++;
                    node.right.val = Math.max(node.val, node.right.val);
                    queue.offer(node.right);
                }
            }
        }
        return res;
        
    }
}
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
    public boolean isValidBST(TreeNode root) {
        // post order
        // if node.val <= maxLeft or >= smallestRight, it's false
        return traversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
        
    }
    public boolean traversal(TreeNode node, long min, long max){
        // base case
        if(node==null) return true;
        // left
        // Check if the current node violates the min/max constraint
        if (node.val <= min || node.val >= max) return false;
        
        boolean left = traversal(node.left, min, node.val);
        // right
        boolean right = traversal(node.right, node.val, max);
        // node
        return left && right;
    }
}
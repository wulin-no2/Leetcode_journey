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
    public int maxDepth(TreeNode root) {
        // post order
        return height(root);
        
    }
    public int height(TreeNode node){
        // base case
        if(node == null) return 0;
        
        // left 
        int left = height(node.left);
        
        // right
        int right = height(node.right);
        
        // node
        return Math.max(right, left) + 1;
    }
    
}
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

    public boolean isBalanced(TreeNode root) {
        // each node should be balanced. post order
        int res = height(root);
        return res != -1;
    }
    public int height(TreeNode node) {
        // base case
        if(node == null) return 0;
        // left
        int left = height(node.left);
        // right
        int right = height(node.right);
        // node
        if(left== -1 || right == -1 || Math.abs(left - right) > 1) return -1; 
        return Math.max(left, right) + 1;  
    }
}
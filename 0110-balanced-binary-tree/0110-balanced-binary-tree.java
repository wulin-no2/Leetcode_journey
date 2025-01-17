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
    int res = 0;
    public boolean isBalanced(TreeNode root) {
        //for each node, if Math.abs(left-right) <= 1;
        height(root);
        return res != -1;
        
    }
    public int height(TreeNode node){
        // base case
        if(node == null) return 0;
        // left
        int left = height(node.left);
        // right
        int right = height(node.right);
        if(Math.abs(left-right) > 1) res = -1;
        // node
        return Math.max(left, right) + 1;
    }
}
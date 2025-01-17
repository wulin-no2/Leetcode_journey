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
        // pre order
        // trace it's max and min, ensure each subtree is always within the range;
        return traverse(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean traverse(TreeNode node, long max, long min){
        // base case
        if(node==null) return true;
        if(node.val >= max || node.val <= min) return false;
        // left && right
        return traverse(node.left, node.val, min) && traverse(node.right, max, node.val);




    }
}
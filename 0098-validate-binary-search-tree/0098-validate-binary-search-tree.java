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
        // post order traversal
        // min of left child should < node.val;
        // max of right child should > node.val;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return traversal(root, min, max);
    }
    public boolean traversal(TreeNode node, long min, long max){
        // base case
        if(node==null) return true;
        if(node.val <= min || node.val >= max) return false;
        // left 
        boolean left = traversal(node.left, min, node.val);
        // right        
        boolean right = traversal(node.right, node.val, max);
        // node
        return left && right;
    }
}
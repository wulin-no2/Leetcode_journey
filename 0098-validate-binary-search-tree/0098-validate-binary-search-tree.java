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
    // For bst, every node.val is limited by it's all ancestors
    // the limits spread from top to down
    public boolean isValidBST(TreeNode root) {
        return isValidateTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidateTree(TreeNode root, long min, long max){
        if(root == null) return true;
        // top to down, pre order
        if(root.val <= min || root.val >= max) return false;
        return isValidateTree(root.left, min, root.val) && isValidateTree(root.right, root.val, max);
    }
}
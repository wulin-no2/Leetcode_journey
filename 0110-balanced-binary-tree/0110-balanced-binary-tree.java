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
        // if for every node, Math.abs(left.height - right.height) <= 1, then balanced;
        // we go from node to root; post order, children give information to parents;
        // left, right, node; dfs;
        if(root == null) return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right && Math.abs(height(root.left) - height(root.right)) <= 1;

        
    }
    public int height(TreeNode root) {
        // left, right, node
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}
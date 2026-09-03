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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter = max(height(left) + height(right), diameter(left), diameter(right))
        // from down to up, post order
        height(root);
        return diameter;
        
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        diameter = Math.max(leftHeight + rightHeight, diameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
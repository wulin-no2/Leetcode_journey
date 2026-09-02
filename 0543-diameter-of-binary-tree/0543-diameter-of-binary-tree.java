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
    public int diameterOfBinaryTree(TreeNode root) {
        // post order, update from down to up
        // diameter of node = Math.max(diameter of left, diameter of right, length of left + length of right)
        // left first:
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int temp = Math.max(left, right);
        return Math.max(temp, maxLength(root.left) + maxLength(root.right));
    }
    public int maxLength(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxLength(root.left), maxLength(root.right)) + 1;
    }
}
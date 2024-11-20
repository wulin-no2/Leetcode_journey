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
    public TreeNode invertTree(TreeNode root) {
        // post order traverse
        // invert left, invert right, return to node
        return invert(root);
    }
    public TreeNode invert(TreeNode node){
        // base case
        if(node == null) return node;
        TreeNode temp = node.left;
        // left
        TreeNode left = invert(node.left);
        // right 
        TreeNode right = invert(node.right);
        // node
        node.left = right;
        node.right = left;
        return node;
    }
}
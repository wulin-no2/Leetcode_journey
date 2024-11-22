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
        // post order traversal
        return invert(root);
        
        
    }
    public TreeNode invert(TreeNode node){
        // base case 
        if(node==null) return node;
        // left
        TreeNode left = invert(node.right);
        // right 
        TreeNode right = invert(node.left);
        // node
        node.left = left;
        node.right = right;
        return node;
    }
}
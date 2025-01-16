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
        // post order
        return traverse(root);
        
    }
    public TreeNode traverse(TreeNode node){
        //base case
        if(node==null) return node;
        // left 
        TreeNode left = traverse(node.left);
        
        // right
        TreeNode right = traverse(node.right);
        node.left = right;
        node.right = left;
        // node
        return node;
    }
}
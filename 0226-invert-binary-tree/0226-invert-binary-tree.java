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
        // post order. invert children, then pass it to the parent node;
        TreeNode result = traversal(root);
        return result;
    }
    public TreeNode traversal(TreeNode node){
        //base case:
        if(node==null) return node;
        if(node.left==null && node.right==null) return node;
        // left
        TreeNode leftTree = traversal(node.right);
        // right
        TreeNode rightTree = traversal(node.left);
        node.left = leftTree;
        node.right = rightTree;
        // node
        return node;
    }
}
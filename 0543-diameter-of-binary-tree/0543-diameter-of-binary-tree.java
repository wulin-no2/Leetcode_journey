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
        // diameter = height(node.left) + height(node.right);
        // but we have to traverse the whole tree to find the maximum diameter
        height(root);
        return diameter;
        
    }
    public int height(TreeNode node){
        // base case
        if(node==null) return 0;
        // left
        int left = height(node.left);
        // right
        int right = height(node.right);
        diameter = Math.max(diameter, left + right);
        // node
        return Math.max(left, right) + 1;
    }
}
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
        // each node should be balanced
        // what is balanced? Math.abs(leftHeight - rightHeight) <= 1
        // use height() helper function
        // check if the tree is balanced when calculating the height
        // use -1 to check if the tree is balanced;
        return height(root) > -1;

    }
    public int height(TreeNode node){
        // base case 
        if(node==null) return 0;
        // left
        int left = height(node.left);
        // right
        int right= height(node.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        // node
        return Math.max(left, right) + 1;
    }
}
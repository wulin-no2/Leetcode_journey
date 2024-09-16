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
        // if Math.abs(node.left.height-node.right.height)<=1, node is balanced;
        // we use postOrder traverse to calculate the height, and if it's balanced;
        if(getHeight(root)==-1) return false;
        return true;
    }
    
    public int getHeight(TreeNode node){
        // base case:
        if(node==null) return 0;
        if(node.left==null && node.right==null) return 1;
        // one layer:
        // left:
        int left = getHeight(node.left);
        // right:
        int right = getHeight(node.right);
        // node:
        if(left==-1 || right==-1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
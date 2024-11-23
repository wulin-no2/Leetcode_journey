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
    int maxDiameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        // diameter of each node = leftHeight + rightHeight;
        // post order traversal
        // update diameter while traversing
        // current diameter is not necessarily equal to universal max diameter
        height(root);
        return maxDiameter;
    }
    public int height(TreeNode node){
        // base case
        if(node==null) return 0;
        // left
        int left = height(node.left);
        // right
        int right = height(node.right);
        // update diameter
        maxDiameter = Math.max(left + right, maxDiameter);
        // node
        return Math.max(left, right) + 1;
    }
}
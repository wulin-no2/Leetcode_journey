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
    public int maxDepth(TreeNode root) {
        int res = traverse(root);
        return res;
    }
    // traverse it in postOrder and return the height of root
    public int traverse(TreeNode node){
        //base case
        if(node==null) return 0;
        // one layer logic
        // left
        int left = traverse(node.left);
        // right
        int right = traverse(node.right);
        // node
        return Math.max(left, right) + 1;
    }
}
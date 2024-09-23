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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // the diameter of a node = height of left tree + height of right tree
        // postOrder traverse
        traverse(root);
        return res;
    }
    public int traverse(TreeNode root){
        // base case
        if(root==null) return 0;
        // one layer logic
        int leftH = traverse(root.left);
        int rightH = traverse(root.right);
        res = Math.max(res, leftH + rightH);
        //System.out.println("res is", res);
        return Math.max(leftH, rightH) + 1;
    }
}
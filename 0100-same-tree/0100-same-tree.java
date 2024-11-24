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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // post order traversal
        // their left child and right child should be equal
        return traversal(p, q);
        
    }
    public boolean traversal(TreeNode p, TreeNode q){
        // base case
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        
        // left
        boolean left = traversal(p.left, q.left);
        // right
        boolean right = traversal(p.right, q.right);
        // node
        return left && right;
    }
}
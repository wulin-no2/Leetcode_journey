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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // pre order 
        // base case
        // node
        if(isSameTree(root, subRoot)) return true;
        if(root==null) return false; 
        
        // left
        boolean left = isSubtree(root.left, subRoot);
        // right
        boolean right = isSubtree(root.right, subRoot);
        return left || right;
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        // base case
        if(p==null && q==null) return true;
        if(p == null || q==null || p.val != q.val) return false;
        // left
        boolean left = isSameTree(p.left, q.left);
        // right
        boolean right = isSameTree(p.right, q.right);
        // node
        return left && right;
    }
}
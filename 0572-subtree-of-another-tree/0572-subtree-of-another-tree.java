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
        if(isSameTree(root, subRoot)) return true;
        if(root==null && subRoot != null) return false;
        // left
        boolean left = isSubtree(root.left, subRoot);
        // right
        boolean right = isSubtree(root.right, subRoot);
        // node
        return left || right;
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q){

        // base case
        if(p==null && q==null) return true;
        if(p==null || q==null || q.val != p.val) return false;
        // left
        boolean left = isSameTree(q.left, p.left);

        // right
        boolean right = isSameTree(q.right, p.right);

        // node
        return left && right;
    }
}
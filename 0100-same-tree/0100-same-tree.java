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
        // we can do preorder or post order
        // let's do postOrder, dfs;
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        // check left tree first
        boolean left = isSameTree(p.left, q.left);
        if(left == false) return false;
        boolean right = isSameTree(p.right, q.right);
        if(right == false) return false;
        return q.val == p.val;
    }
}
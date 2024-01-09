/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // analyze:
        // let p.val < q.val
        // for a node p 
        // if both of them < p.val,go left; both of them > p.val, go right;
        // if one >= p.val && one =< p.val, then return p;
        // we can use recursive:
        // 1) order them;
        if(p.val > q.val){
            TreeNode temp = q;
            q = p;
            p = temp;
        } 
        // 2) traverse from root;
        if(p.val <= root.val && q.val >= root.val) return root;
        // branch 1: all the left;
        if(q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        // branch 2: all the right;
        return lowestCommonAncestor(root.right, p, q);
    }
}
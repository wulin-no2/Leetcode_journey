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
        int small = Math.min(p.val,q.val);
        int large = Math.max(p.val,q.val);
        return traverse(root, small, large);

    }
    public TreeNode traverse(TreeNode root, int small, int large){
        // preOrder traverse, similar to binary search;
        // if node.value > large, traverse node.left;
        // if node.value < small, traverse node.right;
        // else return node;
        if(root.val==small || root.val==large) return root;
        if(root.val>large) return traverse(root.left, small, large);
        if(root.val<small) return traverse(root.right, small, large);
        return root;
    }
}
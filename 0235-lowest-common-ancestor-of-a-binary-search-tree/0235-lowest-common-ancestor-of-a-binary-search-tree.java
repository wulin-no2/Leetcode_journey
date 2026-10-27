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
        // similar to binary search
        // if parent.val < smaller.val go to right
        // if parent.val > bigger.val go to left
        // otherwise return parent node
        TreeNode curr = root;
        TreeNode smaller = null;
        TreeNode bigger = null;
        if(p.val >= q.val) {
            smaller = q;
            bigger = p;
        } else {
            smaller = p;
            bigger = q;
        }
        while(curr != null){
            if(curr.val < smaller.val){
                curr = curr.right;
            } else if(curr.val > bigger.val){
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
        
    }
}
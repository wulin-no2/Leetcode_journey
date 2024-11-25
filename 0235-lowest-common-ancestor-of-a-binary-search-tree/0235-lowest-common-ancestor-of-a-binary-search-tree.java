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
        // pre order cause it's a BST
        // if node.val >= lower and <= higher, then it's what we need
        // if node.val >= higher. then go find left child
        // if node.val <= lower. then go find right child
        return traversal(root, p, q);
        
    }
    public TreeNode traversal(TreeNode node, TreeNode p, TreeNode q){
        int high = Math.max(p.val, q.val);
        int low = Math.min(p.val, q.val);
        // base case
        if(node.val >= low && node.val <= high) return node;
        // node
        // left 
        if(node.val <= low) return traversal(node.right, p, q);
        // right
        else return traversal(node.left, p, q);
    }
}
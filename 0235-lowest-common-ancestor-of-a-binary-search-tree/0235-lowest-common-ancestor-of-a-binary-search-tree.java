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
                // pre order
                return traverse(root, p, q);
        
    }
    public TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
        // base case
        if(root.val == p.val || root.val == q.val) return root;
        if(p.val > q.val) {TreeNode temp = p; p = q; q = temp;} // p is smaller
        // node
        if(root.val > p.val && root.val < q.val) return root;

        // left
        if(root.val > q.val) return traverse(root.left, p, q);
        // right
        else return traverse(root.right, p, q);
    }
}
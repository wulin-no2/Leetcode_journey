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
        // recursive:
        if(root.val == p.val || root.val == q.val) return root;
        if(inTree(root.left, p) && inTree(root.left, q)) return lowestCommonAncestor(root.left, p, q);
        if(inTree(root.right, p) && inTree(root.right, q)) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    // check if Node temp is in the tree; o(n)
    private boolean inTree(TreeNode root, TreeNode temp){
        if(root == null || temp == null) return false;
        if(root.val == temp.val) return true;
        return inTree(root.left, temp) || inTree(root.right, temp);   
    }
}
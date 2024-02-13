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
        if(root==null) return false;
        // subRoot must be left or right child's subRoot
        return isSame(root, subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        
        
    }
    private boolean isSame(TreeNode p, TreeNode q){
        if(q==null && p==null) return true;
        else if(q==null && p!=null) return false;
        else if(q!=null && p==null) return false;
        else if(q!=null && p!=null && q.val != p.val) return false;
        return isSame(q.left, p.left) && isSame(q.right, p.right);
    }
}
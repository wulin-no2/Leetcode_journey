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
        // subRoot should at least be the same tree with a child branch
        // postOrder, from children to parents;
        if(subRoot == null) return true;
        if(root == null) return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);

    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null) return p == q;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
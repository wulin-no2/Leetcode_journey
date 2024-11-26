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
    int count = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        // BST, in order, kth node
        count = k;
        traversal(root);
        return res;

    }
    public void traversal(TreeNode node){
        if(node==null) return;
        traversal(node.left);
        count--;
        if(count==0) {res = node.val; return;}
        traversal(node.right);
    }

}
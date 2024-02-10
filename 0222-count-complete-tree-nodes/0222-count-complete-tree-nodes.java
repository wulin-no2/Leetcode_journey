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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int heightL = 0;
        int heightR = 0;
        // calculate left height;
        TreeNode p = root;
        while(p != null){
            p = p.left;
            heightL++;
        }
        // calculate right height;
        p = root;
        while(p != null){
            p = p.right;
            heightR++;
        }
        // if it's complete tree, return res;
        if(heightL == heightR) return (1 << heightL) - 1;
        // else, recursive until find the complete child tree;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
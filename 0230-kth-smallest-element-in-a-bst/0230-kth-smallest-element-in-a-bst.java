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
    int res = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        // in order
        // count down until k = 0;
        count = k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode node){
        // inorder
        // base case

        if(node == null) return;


        // left
        traverse(node.left);

        // node
        count--;
        if(count==0) {res = node.val; return;}

        // right
        traverse(node.right);
        


    }
}
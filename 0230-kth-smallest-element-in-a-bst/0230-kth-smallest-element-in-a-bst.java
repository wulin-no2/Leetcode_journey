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
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        // in order traversal, find the kth node and return its value
        count = k;
        traversal(root);
        return res;
        
    }
    public void traversal(TreeNode node){
        // base case 
        if(node==null) return;
        // left 
        traversal(node.left);
        // node 
        count--;
        if(count==0) res = node.val;
        // right
        traversal(node.right);
    }
}
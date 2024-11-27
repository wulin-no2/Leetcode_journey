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
    int res = 0;
    public int goodNodes(TreeNode root) {
        // it's good if the max until now is <= node.val;
        // pre order
        traversal(root, root.val);
        return res;
        
        
    }
    public void traversal(TreeNode node, int max){
        // base case
        if(node == null) return;
        // node
        if(node.val >= max) res++;
        max = Math.max(node.val, max);
        
        // left
        traversal(node.left, max);
        // right
        traversal(node.right, max);
        
    }
}
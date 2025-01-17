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
        // pre order, if maxCurrent <= node.val; then it's good
        traverse(root, Integer.MIN_VALUE);
        return res;

        
    }
    public void traverse(TreeNode node, int max){
        // node
        if(node == null) return;
        if(max <= node.val) {res++; max = Math.max(max, node.val);}
        // left
        traverse(node.left, max);

        // right
        traverse(node.right, max);


    }
}
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
        // pre order
        // record the max from root until current
        // if current is the max, then it's good
        traversal(root, root.val); // root.val as the initial max
        return res;
        
        
    }
    public void traversal(TreeNode node, int currentMax){
        // base case
        if(node==null) return;
        // node
        if(node.val >= currentMax) res++; 
        currentMax = Math.max(node.val, currentMax);

        // left
        if(node.left != null) traversal(node.left, currentMax);
        // right
        if(node.right != null) traversal(node.right, currentMax); 
        
    }
}

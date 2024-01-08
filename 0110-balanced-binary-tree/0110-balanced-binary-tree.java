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
    public boolean isBalanced(TreeNode root) {
        // analyze:
        // if both the height of the left child and the height of right child <=1, return true;
        // how to get the height of a node?
        // DFS, use a pointer, while the pointer has a child, h++; pointer move to its left child or its right child;
        // use recursive approach:
        // base case:
        if(root == null){
            return true;
        }
        return (Math.abs(h(root.left) - h(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
            
        
    }
    // write a method to get height:
    public int h(TreeNode root){
        if(root == null){return 0;}
        return  Math.max(h(root.left), h(root.right)) + 1;
    }
}
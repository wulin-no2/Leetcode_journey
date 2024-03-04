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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else if(key==root.val) {
            // choose the biggest node from left or the smallest node from rght;
            // reconstruct;
            if(root.left==null && root.right==null) return null;
            if(root.left!=null){
                // find biggest element of left as root;
                TreeNode p = findBiggest(root.left);
                p.left = deleteNode(root.left, p.val);
                p.right = root.right;
                root = p; 
            }
            else root = root.right; 
        }
        return root;
    }
    private TreeNode findBiggest(TreeNode node){
        TreeNode p = node;
        while(p.right!=null){
            p = p.right;
        }
        return p;
    } 
}
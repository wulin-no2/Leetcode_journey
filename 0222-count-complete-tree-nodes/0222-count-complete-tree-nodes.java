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
        //TreeNode left = root.left;
        //TreeNode right = root.right;
        int heightL = 0;
        int heightR = 0;
        TreeNode p = root;
        while(p != null){
            p = p.left;
            heightL++;
        }
        p = root;
        while(p != null){
            p = p.right;
            heightR++;
        }
        if(heightL == heightR) return (1 << heightL) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
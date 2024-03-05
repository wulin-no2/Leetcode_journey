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
    public int minCameraCover(TreeNode root) {
        // check if root isn't cover; if isn't, res++;
        if(postOrder(root) == 0) res++;
        return res;
    }
    /**
     state of node:
       0: isn't cover
       1: camera
       2: cover
    postOrder from leaf to root; cause we need to add cameras in the parent of leaves, which will make camera least;
     */
    public int postOrder(TreeNode node){
        // null should be seen as cover state, so that leaf can be cover state;
        if(node == null) return 2;
        // left state;
        int left = postOrder(node.left);
        // right state;
        int right = postOrder(node.right);
        // now handle the current node:
        // if left and right are 2, then node should be 0, isn't cover;
        if(left == 2 && right == 2) return 0;
        // if at least one child isn't cover, node should be camera;
        if(left == 0 || right == 0){res++; return 1;}
        // if at least one child is camera, node should be cover state;
        if(left == 1 || right == 1) return 2;
        // return whatever so that syntax right;
        return -1;
    }
}
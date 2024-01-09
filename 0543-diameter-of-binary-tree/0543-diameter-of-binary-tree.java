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
    /*
    public int diameterOfBinaryTree(TreeNode root) {
        // analyze:
        // if level is 1, res = 0; level is 2, res = 1; 
        // res = max(each node's height of left child + height of right child) 
        // how to avoid redundant calculation? now it's O(n^2)
        /*
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int max = 0;
        // use a point to traverse;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        while(! stack.isEmpty()){
            p = stack.pop();
            max = Math.max(max, h(p.left) + h(p.right));
            if(p.left != null){
                stack.push(p.left);
            }
            if(p.right != null){
                stack.push(p.right);
            }
        }
        return max;
    }
    // O(n)
    private int h(TreeNode root){
        if(root == null) return 0;
        // use a point to traverse;
        // TreeNode p = root;
        // if(root.left == null && root.right == null) return 0;-----------shouldn't add this line. why???
        return Math.max(h(root.left), h(root.right)) + 1; 
    }
    */
    
    // how to make it better? 
    //we can calculate the diameter each time we get height.
    // then diameter will be a viarable of the class;
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        height(root);
        return max;
        
    }
    private int height(TreeNode root){
        //if root==null height==0
        if(root == null) return 0;
        
        int L = height(root.left);
        int R = height(root.right);
        //ans signfies(no. of nodes farthest apart) or the DIAMETER
        max = Math.max(max, L + R);
        //height of the tree is max of LST & RST +1
        return Math.max(L, R) + 1;
    }
    
}
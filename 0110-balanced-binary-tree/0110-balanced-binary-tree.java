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
    //boolean res = true;
    private int h(TreeNode root){
        if(root == null) return 0;
        int leftHeight = h(root.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced
        
        int rightHeight = h(root.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(h(root.left), h(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return h(root) != -1;
        // new attempt in 0210;
        
        // analyze:
        // if both the left child and the right child is balanced and their height difference <= 1, return true;
        // how to get the height of a node?
        // DFS, use a pointer, while the pointer has a child, h++; pointer move to its left child or its right child;
        // use recursive approach, but O(n^2):
        /*
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
    */
        
        // the second approach, optimized by checking if subtree is balanced in the h() method:
        // now the time complexity is O(n), space complexity is O(n)
        /* solution before:
        // base case:
        if(root == null){
            return true;
        }
        int h1 = h(root.left);
        int h2 = h(root.right);
        return Math.abs(h1 - h2) <= 1 && res;
    }
    public int h(TreeNode root){
        if(root == null){return 0;}
        int height1 = h(root.left);
        int height2 = h(root.right);
        int height = Math.max(height1, height2) + 1;
        if (Math.abs(height1 - height2) > 1){
            res = false;
        }
        return height;
        */
    }
}
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
    public TreeNode invertTree(TreeNode root) {
        // use recursive approach:
        /* Time Complexity : O(n), Space Complexity : O(n)
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
        */
        
        // use iterative approach:
        // it's levelOrder, use linkedlist to create a queue;
        LinkedList<TreeNode> q = new LinkedList<>();
        // base case:
        if(root == null){
            return root;
        }
        q.add(root);
        // loop until empty;
        while(!q.isEmpty()){
            // get a node from front;
            TreeNode temp = q.poll();
            // see if it has children, enqueue it;
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }       
            // swap them;
            TreeNode p = temp.left;
            temp.left = temp.right;
            temp.right = p;
        }
        return root;  
        
    }
}
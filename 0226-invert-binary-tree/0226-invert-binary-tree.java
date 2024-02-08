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
        // 0208
        // recursive first: pre-order or post-order
        /*
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
        */
        // irerative: level order
        if(root == null) return root;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size -- > 0){
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                TreeNode temp1 = temp.right;
                temp.right = temp.left;
                temp.left = temp1;
            }
            
        }
        return root;
        
        
        
        
        
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
        // it's similar to levelOrder, use linkedlist to create a queue;
        // analyze:
        /*
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
        */
    }
}
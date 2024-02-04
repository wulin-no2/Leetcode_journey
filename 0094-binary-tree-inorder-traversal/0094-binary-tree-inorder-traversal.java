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
    public List<Integer> inorderTraversal(TreeNode root) {
        // recursive approach. 0204
        /*
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
        */
        // iterative approach.
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left == null && temp.right == null) list.add(temp.val);
            else if(temp.right != null && temp.left == null) {stack.push(temp.right); stack.push(temp); temp.right = null;}
            else if(temp.right != null && temp.left != null) {stack.push(temp.right); stack.push(temp); stack.push(temp.left); temp.right = null;temp.left = null;}
            else {stack.push(temp); stack.push(temp.left); temp.left = null;}
        }
        return list;
        
        // recursive approach: 2024.1.7.23.52;
        /*
        List<Integer> arr = new ArrayList<>();
        // base case:
        if(root == null){
            return arr;
        }
        arr.addAll(inorderTraversal(root.left));
        arr.add(root.val);
        arr.addAll(inorderTraversal(root.right));
        return arr;
        */
        
        // iterative approach:
        // first, go to the leftmost;
        //      if a node has left children, push in stack, go to left child;
        // if a node has no left child, add its value into arr and see right child;
        
        // use stack;
        /* solution before:
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return arr;
        }
        // use a pointer:
        TreeNode p = root;
        while(! stack.isEmpty() || p!= null){
            // traverse until the leftmost;
            while(p != null){
                stack.add(p);
                p = p.left;
            }
            // pop a node and check;
            p = stack.pop();
            arr.add(p.val);
            p = p.right; 
        }
        
        return arr;
        */
    }
}
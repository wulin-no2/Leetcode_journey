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
    public List<Integer> preorderTraversal(TreeNode root) {
        // analyze:
        // we need an arraylist to store the values;
        // we can use recursive approach or iterative approach:
        
        // first, recursive approach: done at 22:02 Jan.7.2024
        // time and space: 0(n). 
        
        /* ArrayList<Integer> arr = new ArrayList<>();
        // base case:
        if(root == null){
            return arr;
        }
        arr.add(root.val);
        arr.addAll(preorderTraversal(root.left));
        arr.addAll(preorderTraversal(root.right));
        return arr;
        */
        
        // second, iterative approach:
        // every time, we pop a node and add the value of root into the arrayList,
        // if the node has children, 
        // we push right child into stack, then left;
        // until the stack is empty.
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        // base case:
        if(root == null){
            return arr;
        }
        // use a pointer to traverse:
        TreeNode p = null;
        stack.push(root);
        while(! stack.isEmpty()){
            p = stack.pop();
            arr.add(p.val);
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                stack.push(p.left);
            }
        }
        return arr;
        
        
        
        
        
        
        
        /* following is iterative approach before.
        List<Integer> arrayList1 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(! stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                arrayList1.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return arrayList1;
        */
    }
}
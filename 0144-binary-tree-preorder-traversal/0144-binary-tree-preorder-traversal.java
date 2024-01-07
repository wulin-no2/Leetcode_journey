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
        
        // first, recursive approach:
        ArrayList<Integer> arr = new ArrayList<>();
        // base case:
        if(root == null){
            return arr;
        }
        arr.add(root.val);
        arr.addAll(preorderTraversal(root.left));
        arr.addAll(preorderTraversal(root.right));
        return arr;
        
        // every time, we add the value into the arrayList, then
        // we push them into stack.if the node has children, 
        // right child first, left child last;
        // then pop an elements;
        // repeat the above process;
        
        
        
        
        
        
        
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
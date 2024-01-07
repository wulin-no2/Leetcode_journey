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
    public List<Integer> postorderTraversal(TreeNode root) {
        // analyze:
        // 2 approach:
        // first, recursive: done at 22:25, Jan.7.2024
        /*
        ArrayList<Integer> arr = new ArrayList<>();
        // base case:
        if(root == null){
            return arr;
        }
        arr.addAll(postorderTraversal(root.left));
        arr.addAll(postorderTraversal(root.right));
        arr.add(root.val);
        return arr;
        */
        
        // second, iterative, use stack:
        List<Integer> arr = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return arr;
        }
        stack.push(root);
        TreeNode p = root;
        // 
        while(! stack.isEmpty()){
            p = stack.pop();
            arr.add(0, p.val);
            if(p.left != null){
                stack.push(p.left);
            }
            if(p.right != null){
                stack.push(p.right);
            }
        }
        return arr;
    }
}
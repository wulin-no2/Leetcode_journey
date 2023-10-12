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
    }
}
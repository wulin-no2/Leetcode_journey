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
        if(root != null){
        arrayList1.add(root.val);
        arrayList1.addAll(preorderTraversal(root.left));
        arrayList1.addAll(preorderTraversal(root.right));
        }
        return arrayList1;
    }
}
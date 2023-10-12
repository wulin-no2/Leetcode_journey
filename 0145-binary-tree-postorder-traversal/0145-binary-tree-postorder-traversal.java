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
        List<Integer> arrL = new ArrayList<>();
        if(root != null){
            arrL.addAll(postorderTraversal(root.left));
            arrL.addAll(postorderTraversal(root.right));
            arrL.add(root.val);
        }
        return arrL;
    }
}
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        if(nums.length==1) return new TreeNode(nums[0]); 
        TreeNode root;
        if(nums.length % 2 == 0){
            root = new TreeNode(nums[nums.length / 2 - 1]); 
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2-1));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        }
        else{
            root = new TreeNode(nums[nums.length / 2]); 
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
            
        }
        return root;
    }
}
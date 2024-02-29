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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // DIM: 
        if(nums.length == 0) return null;
        // find maxIndex:
        int maxIndex = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(max < nums[i]){maxIndex = i; max = nums[i];}
        }
        // get root and it's children;
        TreeNode root = new TreeNode(nums[maxIndex]);
        int[] leftNums = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightNums = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
        // recursive:
        root.left = constructMaximumBinaryTree(leftNums); 
        root.right = constructMaximumBinaryTree(rightNums); 
        return root;
        
    }
}
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
        /* DIM: 
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
        */
        // from GPT:
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num) {
                // Current node is the parent of the last node in the stack
                curr.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                // The last node in the stack is the parent of the current node
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        // The bottom of the stack holds the root of the Maximum Binary Tree
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop(); // The last element is the root
        }
        return root;
    }
}
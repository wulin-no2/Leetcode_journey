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
    public List<Integer> rightSideView(TreeNode root) {
        // from 21:30; analyze 2min;
        // BFS, return the last value of each level
        // Use queue
        // if can't write it, please review BFS again. But put right first, then left;
        // Use queue to traverse, use ArrayList to store the result;
        // use height to record the height. before height--, add the value to result;
        
        
        // base cases:
        if(root == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        // if(root.val == null) return res;
        
        // use queue to traverse;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //int height = height(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode p = queue.poll();
                if(i == levelSize - 1) {
                    res.add(p.val);
                }
                if(p.left != null) queue.offer(p.left);
                if(p.right != null) queue.offer(p.right);
            }
        }
        return res; 
           
    // o(n)
    // private int height(TreeNode root){
    //     if(root == null) return 0;
    //     if(root.left == null || root.right == null) return 1;
    //     return Math.max(height(root.right), height(root.left)) + 1;
    }
}
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
    public int findBottomLeftValue(TreeNode root) {
        // remember the leftmost of each layer, update the value when level-order traverse;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            int sizeTemp = size;
            while(size-->0){
                TreeNode temp = q.poll();
                if(size + 1 == sizeTemp) res = temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
        
        return res;
    }
}
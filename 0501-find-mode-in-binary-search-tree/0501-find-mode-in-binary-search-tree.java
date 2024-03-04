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
    TreeNode prev = null;
    List<Integer> list = new ArrayList<>();
    int currentCount = 0;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private void inOrder(TreeNode node){
        if(node==null) return;
        // left
        inOrder(node.left);
        
        // Process current node
        // first see count;
        if (prev != null && node.val == prev.val) {
            currentCount++;
        } else {
            currentCount = 1;
        }
        // then update list;
        if (currentCount > maxCount) {
            maxCount = currentCount;
            list.clear();
            list.add(node.val);
        } else if (currentCount == maxCount) {
            list.add(node.val);
        }
        // be sure to move prev;
        prev = node; // Update prev
        // right
        inOrder(node.right);   
    }
}
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // can't do it, juct copy one and see why
        // base case:
        List<List<Integer>> res = new ArrayList<>(); 
        if (root == null) return res;  
        // use a queue:
        LinkedList<TreeNode> q = new LinkedList<>();  
        q.add(root);  
        // each time, we retrive a node, add the value, then see if it has children. if it has, enqueue the children from left to right;
        // repeat until the queue is empty;
        // notice: for each node, we need a list to store the pair of values; each end of the node, we add the list into the result list;
        while (!q.isEmpty()) {  
          List<Integer> list = new ArrayList<>();  
          int size = q.size();
          for (int i = 0; i < size; i++) {  
            TreeNode temp = q.poll();  
            list.add(temp.val);  
            if (temp.left != null) {  
              q.add(temp.left);  
            }
            if (temp.right != null) {  
              q.add(temp.right);  
            }  
          }  
          res.add(list);   
        }  
        return res;
        
    }
}
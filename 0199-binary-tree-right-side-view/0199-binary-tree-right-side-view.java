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
    /*
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
        while(!queue.isEmpty()){
            // each time, check the size of queue. poll all of them and offer again;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode p = queue.poll();
                if(i == 0) {
                    res.add(p.val);
                }
                if(p.right != null) queue.offer(p.right);
                if(p.left != null) queue.offer(p.left);
            }
        }
        return res; 
    }
    */
    // a simple recursive approach from discuss;
    
    public List<Integer> rightSideView(TreeNode root) {
        var list = new ArrayList<Integer>();
        rec(root,list,0);
        return list;
    }
    void rec(TreeNode root,ArrayList<Integer> list, int depth){
        if (root == null) return;
        if(list.size()==depth) list.add(root.val);
        if(root.right!=null) rec(root.right,list,depth+1);
        if(root.left!=null) rec(root.left,list,depth+1);
    }
    //
}
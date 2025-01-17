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
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // use q
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(! q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                size--;
            }
            res.add(list);
        }
        return res;

        
    }
}
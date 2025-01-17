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
        // lever order
        // record val when q.size()==1
        if(root==null) return new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> res = new ArrayList<>();
        while(! q.isEmpty()){
            int size = q.size();
            while(size > 0){
                TreeNode node = q.poll();
                if(size==1) res.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                size--;
            }
        }
        return res;

    }
}
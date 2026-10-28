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
    public int goodNodes(TreeNode root) {
        // for every node:
        // record if the children of the node is good and update children's vals as the biggest val from root until here when handing the val
        int res = 0;
        if(root == null) return res;
        // level order
        Queue<TreeNode> queue = new ArrayDeque<>();
        // use a separate queue to record the maxValueInThePath;
        Queue<Integer> maxPaths = new ArrayDeque<>();
        queue.offer(root);
        maxPaths.offer(root.val);
        res++;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                TreeNode node = queue.poll();
                int maxPath = maxPaths.poll();
                if(node.left != null){
                    if(maxPath <= node.left.val) res++;
                    maxPaths.offer(Math.max(maxPath, node.left.val));
                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(maxPath <= node.right.val) res++;
                    maxPaths.offer(Math.max(maxPath, node.right.val));
                    queue.offer(node.right);
                }
            }
        }
        return res;
        
    }
}
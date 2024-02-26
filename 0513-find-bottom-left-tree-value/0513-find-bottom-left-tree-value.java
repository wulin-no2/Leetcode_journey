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
        dfs(root,1);
        return res;
        // remember the leftmost of each layer, update the value when level-order traverse;
        /* first approach: BFS
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
        */
    }
    // 2 approach: DFS-recursively. find the maxDepth, then left child first
    // record the first child of the maxDepth level.
    int maxDepth = Integer.MIN_VALUE;
    int res;
    private void dfs(TreeNode root, int depth){
        // when should we end? find the leaf:
        if(root.left==null && root.right==null){
            if(depth > maxDepth){
                maxDepth = depth;
                res = root.val; 
            }
            return;
        }
        // how to recursive each step?
        if(root.left!=null){
            depth++;
            dfs(root.left, depth);
            depth--;
        }
        if(root.right!=null){
            depth++;
            dfs(root.right, depth);
            depth--;
        }
    }
}
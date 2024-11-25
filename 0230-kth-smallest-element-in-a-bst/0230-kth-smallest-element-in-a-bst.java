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
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    public int kthSmallest(TreeNode root, int k) {
        // use a minHeap with k length track the fistKSmallest values when traversing
        traversal(root, k);
        return pq.poll();
    }
    public void traversal(TreeNode node, int k){
        // base case
        if(node==null) return;
        pq.offer(node.val);
        if(pq.size() > k) pq.poll();
        traversal(node.left, k);
        traversal(node.right, k);
    }
}
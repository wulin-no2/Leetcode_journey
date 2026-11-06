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
    // for preorder, we know it's (node, leftsubtree, rightsubtree);
    // for inorder, we know it's (leftsubtree, node, rightsubtree);
    // so if we walk through preorder, then find the index of the node in inorder - using a map
    // we can split inorder into left , node, right subarray, then build recursively.
    int indexPreorder = 0; // for walking through preorder
    Map<Integer, Integer> map = new HashMap<>(); // value, index
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
        return build(preorder, map, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, Map<Integer, Integer> map, int left, int right){
        if(left > right) return null;
        int val = preorder[indexPreorder];
        TreeNode node = new TreeNode(val);
        indexPreorder++;
        int middle = map.get(val);
        node.left = build(preorder, map, left, middle - 1);
        node.right = build(preorder, map, middle + 1, right);
        return node;
    }
}
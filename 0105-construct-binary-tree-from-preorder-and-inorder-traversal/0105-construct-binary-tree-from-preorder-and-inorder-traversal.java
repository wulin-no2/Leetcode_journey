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
    /* don't understand;
    private int i = 0;
    private int p = 0;
        // from 00:34, can't do it
    
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //return build(preorder, inorder, Integer.MIN_VALUE);
            return build(preorder, inorder, 3001);
        }

        private TreeNode build(int[] preorder, int[] inorder, int stop) {
            if (p >= preorder.length) {
                return null;
            }
            if (inorder[i] == stop) {
                ++i;
                return null;
            }

            TreeNode node = new TreeNode(preorder[p++]);
            node.left = build(preorder, inorder, node.val);
            node.right = build(preorder, inorder, stop);
            return node;
        }
        */
    //another approach:
    int[] preorder;
    int[] inorder;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.index = 0;
        return fun(0, inorder.length - 1);
    }

    public TreeNode fun(int l, int r) {
        if(l > r) {
            return null;
        }
        int mid = find(preorder[index++], l, r);
        return new TreeNode(inorder[mid], fun(l, mid - 1), fun(mid + 1, r));
    }

    public int find(int num, int l, int r) {
        for(int i = l; i <= r; i++) {
            if(num == inorder[i]) {
                return i;
            }
        }
        return -1;

    }
}
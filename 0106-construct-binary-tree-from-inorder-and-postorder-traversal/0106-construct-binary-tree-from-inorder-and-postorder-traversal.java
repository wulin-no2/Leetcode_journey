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
    /* first approach: 20240226
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 1) get root from postorder;
        // 2) split inorder into 2 parts;
        // 3) split postorder into 2 parts;
        // 4) use leftinorder and leftpostorder to get left child;
        // 5) use rightinorder and rightpostorder to get right child;
        // 6) return root;
        // 1)
        if(postorder.length==0) return null;
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        if(postorder.length==1) return root;
        // 2)
        int index = -1;
        for(int i = 0 ; i < inorder.length; i++){if(inorder[i]==val) {index = i; break;}}
        int[] leftinorder = new int[index];
        int[] rightinorder = new int[inorder.length - index - 1];
        for(int i = 0 ; i < index; i++) leftinorder[i] = inorder[i];
        for(int i = index + 1 ; i < inorder.length; i++) rightinorder[i-(index + 1)] = inorder[i];
        //System.out.println("index: " + index + " leftinorder: " + leftinorder.length + " rightinorder: " + rightinorder.length);
        // 3)
        int[] leftpostorder = new int[leftinorder.length];
        int[] rightpostorder = new int[rightinorder.length];
        for(int i = 0 ; i < leftinorder.length; i++) leftpostorder[i] = postorder[i];
        for(int i = leftinorder.length; i < leftinorder.length + rightinorder.length; i++) rightpostorder[i-(leftinorder.length)] = postorder[i];
        // 4)
        root.left = buildTree(leftinorder,leftpostorder);
        root.right = buildTree(rightinorder,rightpostorder);
        return root;
    }*/
    Map<Integer, Integer> map;  // 方便根据数值查找位置
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }
        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                            postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                            postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
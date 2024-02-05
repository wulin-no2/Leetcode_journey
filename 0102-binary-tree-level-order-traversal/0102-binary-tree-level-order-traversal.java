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
        // 0205
        // use a list to store result;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        // use a queue to BFS:
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            res.add(list);
        }
        return res;
        
        
        
        
        
        
        // can't do it, juct copy one and see why
        // BFS iterative approach:
        /*
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
        */
        
        // DFS recursive approach:
        /* solution before:
        List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		levelOrderHelper(res, root, 0);
		return res;
	}
	
	public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) {
		if (root == null)
			return;
		List<Integer> curr;
		if (level >= res.size()) {
			curr = new ArrayList<>();
			curr.add(root.val);
			res.add(curr);
		} else {
			curr = res.get(level); 
			curr.add(root.val); 
			//res.add(curr); // No need to add the curr into the res, because the res.get(index) method does not remove the index element
		}
		levelOrderHelper(res, root.left, level + 1);
		levelOrderHelper(res, root.right, level + 1);
        */
    }
}
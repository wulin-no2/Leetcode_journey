/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //private int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);

        return String.join(",", list);
    }

    private void serializeDFS(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeDFS(root.left, list);
        serializeDFS(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] index = new int[]{0};
        return deserializeDFS(tokens, index);
    }

    private TreeNode deserializeDFS(String[] tokens, int[] index) {
        // String token = tokens[i];
        // if (token.equals("N")) {
        //     //i++;
        //     return null;
        // }
        if (index[0] >= tokens.length || tokens[index[0]].equals("N")) {
            index[0]++;  // Increment index for the next recursive call
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(tokens[index[0]++]));
        //i++;
        node.left = deserializeDFS(tokens, index);
        node.right = deserializeDFS(tokens, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
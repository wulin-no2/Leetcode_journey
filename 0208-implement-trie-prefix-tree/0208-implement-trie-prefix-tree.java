///* a solution use array Node[];
// TC = o(n), n is the length of word; SC = 26 * n * nums, nums is the numbers of words inserted into trie;
class Node {
    public boolean isWord; 
    public Node[] children = new Node[26];
    public Node() {}
}

public class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) ws.children[c - 'a'] = new Node();
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        Node ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        Node ws = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
//*/
// a solution from discuss with hashmap; array is better
/*
class Trie {

    class TrieNode {
        Map<Integer, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int key = ch - 'a';
            if(!curr.children.containsKey(key)) {
                // create new child node if doesn't exsit
                curr.children.put(key, new TrieNode());
            }

            curr = curr.children.get(key);
        }
        curr.isWord = true;
    }

    // Returns if the word is in the trie. 
    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int key = ch - 'a';
            if(!curr.children.containsKey(key)) {
                return false;
            }
            curr = curr.children.get(key);
        }
        return curr.isWord;
    }

    // Returns if there is any word in the trie that starts with the given prefix. 
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int key = ch - 'a';
            if(!curr.children.containsKey(key)) {
                return false;
            }
            curr = curr.children.get(key);
        }
        return true;
    }
}
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
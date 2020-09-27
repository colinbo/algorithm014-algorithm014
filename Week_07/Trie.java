class TrieNode {

    private int R = 26;
    private TrieNode[] nodes;
    private boolean isEnd;

    public TrieNode(){
        nodes = new TrieNode[R];
    }

    public boolean containsChar(char c){
        int index = c - 'a';
        return nodes[index] != null;
    }

    public TrieNode get(char c){
        int index = c - 'a';
        return nodes[index];
    }

    public void put(char c, TrieNode node){
        int index = c - 'a';
        nodes[index] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode temp = root;
        for (char c : word.toCharArray()){
            if (!temp.containsChar(c)){
                temp.put(c, new TrieNode());
            }
            temp = temp.get(c);
        }
        temp.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return true;
        TrieNode temp = root;
        for (char c : word.toCharArray()){
            if (!temp.containsChar(c)){
                return false;
            }
            temp = temp.get(c);
        }
        if (temp.isEnd()){
            return true;
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return true;
        TrieNode temp = root;
        for (char c : prefix.toCharArray()){
            if (!temp.containsChar(c)){
                return false;
            }
            temp = temp.get(c);
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}

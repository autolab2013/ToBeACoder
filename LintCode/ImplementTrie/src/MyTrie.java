/**
 * Created by Riley on 8/29/2015.
 */

import java.util.ArrayList;

class TrieNode {
    // Initialize your data structure here.
    public boolean end;
    public ArrayList<TrieNode> children;
    private int size = 26;

    public TrieNode() {
        end = false;
        children = new ArrayList<>();
        for(int i=0; i<size; i++) {
            children.add(null);
        }
    }
}

public class MyTrie {
    private TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode root, String s, int i) {
        if(root == null) root = new TrieNode();
        if(i == s.length()) {
            root.end = true;
            return root;
        }
        int id = s.charAt(i) - 'a';
        TrieNode child = root.children.get(id);
        root.children.set(id, insert(child, s, i+1));
        return root;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode root, String word, int i) {
        if(root == null) return false;
        if(i == word.length()) return root.end;
        int id = word.charAt(i) - 'a';
        return search(root.children.get(id), word, i+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(TrieNode root, String s, int i) {
        if(root == null) return false;
        if(i == s.length()) {
            for(TrieNode n : root.children) {
                if(n != null) return true;
            }
            return false;
        }
        int id = s.charAt(i) - 'a';
        TrieNode child = root.children.get(id);
        return startsWith(child, s, i+1);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
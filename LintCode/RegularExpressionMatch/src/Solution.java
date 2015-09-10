/**
 * Created by Riley on 9/2/2015.
 */
public class Solution {

    private TrieNode insert(TrieNode root, TrieNode prev, String s, int i) {
        if(root == null) root = new TrieNode();
        if(i == s.length()) {
            root.isEnd = true;
            return root;
        }
        char c = s.charAt(i);
        if(c == '.') {
            for(int j=0; j<26; j++) {
                root.children.set(j, insert(root.children.get(j), root, s, i+1));
            }
        } else if(c == '*'){
            root = prev;
            if(i == s.length()-1) root = insert(root, prev, s, i+1);
            else {
                int next_c = s.charAt(i+1);
                root.children.set(next, insert(root.children.get(next), root, s, i+1));
            }
        } else {
            int next = c - 'a';
            root.children.set(next, insert(root.children.get(next), root, s, i + 1));
        }
        return root;
    }

    public boolean isMatch(String s, String p) {
        // write your code here
        TrieNode root = new TrieNode();
        root = insert(root, p, 0);
        return isMatch(root, s, 0);
    }

    private boolean isMatch(TrieNode root, String s, int i) {

    }
}

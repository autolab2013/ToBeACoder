import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Riley on 8/30/2015.
 */
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */

    static class TrieNode {
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

    public static class Trie {
        private TrieNode root;

        public Trie() {
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
                return true;
            }
            int id = s.charAt(i) - 'a';
            TrieNode child = root.children.get(id);
            return startsWith(child, s, i+1);
        }
    }

    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<>();
        int rows = board.length;
        if(rows == 0) return result;
        int cols = board[0].length;
        Trie trie = new Trie();
        int max_len = 0;
        for(String str : words) {
            max_len = Math.max(max_len, str.length());
            trie.insert(str);
        }
        HashSet<String> found = new HashSet<>();
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                update(found, result, trie, board, r, c, "", max_len);
            }
        }
        return result;
    }

    private static void update(HashSet<String> set, ArrayList<String> result, Trie trie, char[][] board, int r, int c, String str, int max_len) {
        if(str.length() > max_len || !trie.startsWith(str)) return ;
        char ch = board[r][c];
        str += ch;
        board[r][c] = '*';
        if(trie.search(str) && !set.contains(str)) {
            set.add(str);
            result.add(str);
        }
        if(r-1 >= 0 && board[r-1][c] != '*') update(set, result, trie, board, r-1, c, str, max_len);
        if(c-1 >= 0 && board[r][c-1] != '*') update(set, result, trie, board, r, c-1, str, max_len);
        if(r+1 < board.length && board[r+1][c] != '*') update(set, result, trie, board, r+1, c, str, max_len);
        if(c+1 < board[0].length && board[r][c+1] != '*') update(set, result, trie, board, r, c+1, str, max_len);
        board[r][c] = ch;
    }


    public static void main(String[] args) {
//        ["doaf","agai","dcan"], {"dog","dad","dgdg","can","again"}
//        char[][] board = {{'d', 'o', 'a', 'f'}, {'a', 'g', 'a', 'i'}, {'d', 'c', 'a', 'n'}};
//        ArrayList<String> list = new ArrayList<>();
//        list.add("dog");
//        list.add("dad");
//        list.add("dgdg");
//        list.add("can");
//        list.add("again");
//        ["abce","sfcs","adee"], {"see","se"}
//        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
//        ArrayList<String> list = new ArrayList<>();
//        list.add("see");
//        list.add("se");
//        ["abce","sfes","adee"], {"abceseeefs","abceseedasfe"}
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}};
        ArrayList<String> list = new ArrayList<>();
        list.add("abceseeefs");
        list.add("abceseedasfe");
        wordSearchII(board, list);

    }
}

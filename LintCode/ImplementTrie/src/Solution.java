/**
 * Created by Riley on 8/29/2015.
 */
public class Solution {
    public static void main(String[] args) {
        MyTrie trie = new MyTrie();
        // Your Trie object will be instantiated and called as such:
        // Trie trie = new Trie();
//        trie.insert("somestring");
//        trie.search("key");
        trie.insert("hello");
        System.out.println(trie.startsWith("hello"));
    }
}

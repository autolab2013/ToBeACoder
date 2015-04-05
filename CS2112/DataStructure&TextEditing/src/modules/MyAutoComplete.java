package modules;

import util.Trie;

public class MyAutoComplete implements AutoCompleteModule {
    private Trie my_trie;

    public MyAutoComplete() {
        my_trie = new Trie();
    }

    @Override
    public void addWord(String word) {
        word = word.replaceAll("[^a-zA-Z]", "");
        my_trie.insert(word);
    }

    @Override
    public String getWordForPrefix(String prefix) {
        return my_trie.closestWordToPrefix(prefix);
    }

}

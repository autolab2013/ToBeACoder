package modules;

import util.HashTable;

public class MySpellCheck implements SpellCheckModule {
    private HashTable<String, Boolean> dict;

    public MySpellCheck() {
        dict = new HashTable<>(1);
    }

    @Override
    public void addWord(String word) {
        dict.put(word, true);
    }

    @Override
    public boolean isValidWord(String word) {
        return dict.containsKey(word);
    }

}

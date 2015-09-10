import java.util.ArrayList;

/**
 * Created by Riley on 9/2/2015.
 */
public class TrieNode {
    public boolean isEnd;
    public ArrayList<TrieNode> children;
    private int size = 26;

    public TrieNode() {
        isEnd = false;
        for(int i=0; i<size; i++) {
            children.add(null);
        }
    }
}

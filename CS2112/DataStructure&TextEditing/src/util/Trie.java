package util;

import java.util.ArrayList;

/** A mutable collection of strings.
 * Trie is composed of Nodes
 * every Node has 256 next nodes for 256 ASIC II chars
 */
public class Trie {
    private final int R = 26 * 2; //in us.txt only accept letters
    private Node root;
    private int size;

    private class Node {
        private Node[] next = new Node[R];
        private boolean eow = false; //end of word
    }

    private class BFSNode {
        private String str;
        private Node n;

        public BFSNode(Node n, String s) {
            this.n = n;
            str = s;
        }
    }

    /** Create an empty trie. */
    public Trie() {
        root = null;
        size = 0;
    }

    /** Add {@code elem} to the collection. */
    public void insert(String elem) {
        root = insert(root, elem, 0);
    }

    private Node insert(Node n, String elem, int indx) {
        if (n == null) n = new Node();
        if (indx == elem.length()) {
            n.eow = true;
            return n;
        }
        int next_indx = toIndex(elem.charAt(indx));
        n.next[next_indx] = insert(n.next[next_indx], elem, indx + 1);
        return n;
    }

    /** Remove {@code elem} from the collection, if it is there. */
    public void delete(String elem) {
        root = delete(root, elem, 0);
    }

    private Node delete(Node n, String elem, int d) {
        if (n == null) return null;
        if (d == elem.length())
            n.eow = false;
        else {
            int next = toIndex(elem.charAt(d));
            n.next[next] = delete(n.next[next], elem, d + 1);
        }
        if (n.eow) return n;
        for (Node node : n.next) {
            if (node != null) return n;
        }
        return null;
    }

    /** Return true if this trie contains {@code elem}, false otherwise. */
    public boolean contains(String elem) {
        return contains(root, elem, 0);
    }

    //suppose non-empty string
    private boolean contains(Node n, String elem, int d) {
        if (n == null) return false;
        if (d == elem.length())
            return n.eow;
        else {
            int next = toIndex(elem.charAt(d));
            return contains(n.next[next], elem, d + 1);
        }
    }

    /**
     * Return a word contained in the trie of minimal length
     * with {@code prefix}. If no such word exists, return null.
     */
    public String closestWordToPrefix(String prefix) {
        Node pre_end = closestWordToPrefix(root, prefix, 0);
        if (pre_end == null)
            return "";
        else {
            return BFS(pre_end, prefix);
        }
    }

    private Node closestWordToPrefix(Node n, String prefix, int d) {
        if (n == null || prefix.isEmpty()) return null;
        if (d == prefix.length()) return n;
        int index = toIndex(prefix.charAt(d));
        return closestWordToPrefix(n.next[index], prefix, d + 1);
    }

    private String BFS(Node n, String str) {
        BFSNode bfsn = new BFSNode(n, str);
        ArrayList<BFSNode> queue = new ArrayList<>();
        queue.add(bfsn);
        while (!queue.isEmpty()) {
            BFSNode node = queue.remove(0);
            if (node.n.eow) return node.str;
            for (int i = 0; i < node.n.next.length; i++) {
                Node next = node.n.next[i];
                if (next != null) {
                    bfsn = new BFSNode(next, node.str + toChar(i));
                    queue.add(bfsn);
                }
            }
        }
        return null;
    }

    /**
     * convert index to char
     * @param index
     * @return
     */
    private char toChar(int index) {
        char c = '0';
        if (index >= 26)
            c = (char) (index - 26 + 'a');
        else c = (char) (index + 'A');
        return c;
    }

    /**
     * convert char to int index, 0-51
     * @param c
     * @return
     */
    private int toIndex(char c) {
        int index = -1;
        if (c > 'Z') //lower letter
            index = c - 'a' + 26;
        else index = c - 'A';
        return index;
    }

    /**
     * get the size of trie
     * @return
     */
    public int getSize() {
        return size;
    }

}

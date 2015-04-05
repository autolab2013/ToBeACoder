package Test;

import org.junit.Test;

import util.Trie;

public class TestTrie {

    @Test
    public void test() {
        //build tree, test insert
        Trie my_trie = new Trie();
//        try (BufferedReader br =
//                new BufferedReader(new FileReader("us/US.dic"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                // process the line.
//                line = line.replaceAll("[^a-zA-Z]", "");
//                my_trie.insert(line);
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //test closestWordToPrefix
//        System.out.println(my_trie.closestWordToPrefix("str"));
//        //contains and delete
//        try (BufferedReader br =
//                new BufferedReader(new FileReader("us/US.dic"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                line = line.replaceAll("[^a-zA-Z]", "");
//                assertEquals(true, my_trie.contains(line));
//                my_trie.delete(line);
//                assertEquals(false, my_trie.contains(line));
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxvz";
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(my_trie.toIndex(s.charAt(i)));
//        }
//        for (int i = 0; i < 100; i++) {
//            System.out.println(my_trie.toChar(i));
//        }
    }
}

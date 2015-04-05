package Test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import util.Trie;

public class TestTrie {

    @Test
    public void test() {
        //build tree, test insert
        Trie my_trie = new Trie();
        try (BufferedReader br =
                new BufferedReader(new FileReader("us/US.dic"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                line = line.replaceAll("[^a-zA-Z]", "");
                my_trie.insert(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //test closestWordToPrefix
        System.out.println(my_trie.closestWordToPrefix("circu"));
        //contains and delete
        try (BufferedReader br =
                new BufferedReader(new FileReader("us/US.dic"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z]", "");
                assertEquals(true, my_trie.contains(line));
                my_trie.delete(line);
                assertEquals(false, my_trie.contains(line));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

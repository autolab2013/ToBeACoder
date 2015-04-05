package Test;

import org.junit.Test;

import util.HashTable;

public class HashTableTest {

    @Test
    public void test() {
        HashTable<String, String> table = new HashTable<>(1);
        int size = 100;
        for (int i = 0; i < size; i++) {
            table.put(String.valueOf(i), "test" + i);
            System.out.println(table.get(String.valueOf(i)));
        }

        for (int i = 100; i < 200; i++) {
            System.out.println(i + ": " + table.containsKey(String.valueOf(i)));
//            assertEquals(false, table.containsKey(String.valueOf(i)));
        }

    }
}

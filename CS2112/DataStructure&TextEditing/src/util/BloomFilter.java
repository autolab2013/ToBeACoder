package util;

import java.util.Collection;

/**
 * A collection of elements of type E for which the only operation is
 * a probabilistic membership test.
 */
public class BloomFilter<E> {
    private int bit_arr_len = 0;
    private int hash_num = 0;
    private boolean[] bit_arr = null;

    /**
     * Create a new Bloom filter with {@code elems} inside.
     * The bit array is of length 8 * numBytes.
     * The Bloom filter uses the specified number of hash functions.
     * @param elems The collection of elements to be added to this filter
     * @param numBytes The length of the byte array representing bit array
     * @param numHashFunctions The number of hash functions to be used in this filter
     */
    public BloomFilter(Collection<E> elems, int numBytes, int numHashFunctions) {
        bit_arr_len = 8 * numBytes;
        bit_arr = new boolean[bit_arr_len];
        for (int i = 0; i < bit_arr.length; i++) {
            bit_arr[i] = false;
        }
        hash_num = numHashFunctions;
    }

    /**
     * Add {@code elem} to the Bloom filter.
     */
    public void insert(E elem) {
        int[] index = getHashIndex(elem, hash_num);
        for (int id : index) {
            bit_arr[id] = true;
        }
    }

    //TODO: generate differet hashcode
    private int[] getHashIndex(E elem, int hash_num) {
        return null;
    }

    /**
     * Check whether {@code elem} might be in the collection.
     */
    public boolean mightContain(E elem) {
        int[] indx = getHashIndex(elem, hash_num);
        boolean found = true;
        for (int i : indx) {
            found &= bit_arr[i];
        }
        return found;
    }

}

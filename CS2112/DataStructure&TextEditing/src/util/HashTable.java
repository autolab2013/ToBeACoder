package util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashTable<K, V> implements Map<K, V> {
    /**
     * use chaining for collision
     */
    private final double UPPER = 2; // load factor threshold
    private final double LOWER = 0.5;
    private int elem_num = 0; // number of elements
    private ArrayList<LinkedList<HashEntry>> buckets = new ArrayList<>();
    private Set<K> keyset = new HashSet<>();

    private class HashEntry {
        public K key;
        public V value;

        public HashEntry(K k, V v) {
            key = k;
            value = v;
        }

    }

    /**
     * Initialize a hash table with the specified number of buckets.
     * @param initNumBuckets
     */
    public HashTable(int initNumBuckets) {
        if (initNumBuckets < 1) initNumBuckets = 1;//avoid 0 buckets
        for (int i = 0; i < initNumBuckets; i++) {
            buckets.add(new LinkedList<HashEntry>());
        }
    }

    @Override
    public int size() {
        return elem_num;
    }

    @Override
    public boolean isEmpty() {
        return elem_num == 0;
    }

    private int getBucketIndex(Object key, int bucket_size)
            throws NoSuchAlgorithmException {
        String method = "MD5";
        int code = key.hashCode();
        MessageDigest md = MessageDigest.getInstance(method);
        md.update(String.valueOf(code).getBytes());
        byte[] digest = md.digest();
        BigInteger b_index = new BigInteger(digest);
        int index = b_index.intValue();
        if (index < 0) index = -index;
        return index % bucket_size;
    }

    private double getLoadFactor() {
        return (double) elem_num / buckets.size();
    }

    private void rehash() {
        if (getLoadFactor() >= UPPER || getLoadFactor() <= LOWER) {
            System.out.println("Doing rehash, bucket size: " + buckets.size()
                               + ", elem size: " + size());
            ArrayList<LinkedList<HashEntry>> new_buckets = new ArrayList<>();
            if (getLoadFactor() >= UPPER) {
                for (int i = 0; i < 2 * buckets.size(); i++) {//double buckets size
                    new_buckets.add(new LinkedList<HashEntry>());
                }
            }
            if (getLoadFactor() <= LOWER) {
                if (isEmpty()) return;
                for (int i = 0; i < buckets.size() / 2; i++) {
                    new_buckets.add(new LinkedList<HashEntry>());
                }
            }
            try {// move buckets to new  buckets
                for (K key : keySet()) {
                    V value = get(key);
                    int new_index = getBucketIndex(key, new_buckets.size());
                    new_buckets.get(new_index).addFirst(new HashEntry(key,
                                                                      value));
                }
                buckets = new_buckets;
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean containsKey(Object key) {
        if (get(key) != null)
            return true;
        else return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<HashEntry> list : buckets) {
            for (HashEntry e : list) {
                if (e.value.equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        try {
            int bucket = getBucketIndex(key, buckets.size());
            if (!buckets.get(bucket).isEmpty()) {
                for (HashEntry e : buckets.get(bucket)) {//search linkedlist
                    if (e.key.equals(key)) return e.value;
                }
            }
            return null;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public V put(K key, V value) {
        try {
            elem_num++;
            keyset.add(key);
            int index = getBucketIndex(key, buckets.size());
            LinkedList<HashEntry> bucket = buckets.get(index);
            V prev = null;
            boolean found = false;
            if (!bucket.isEmpty()) {
                for (HashEntry e : bucket) {
                    if (e.key.equals(key)) {
                        e.value = value;
                        found = true;
                    }
                }
            }
            if (!found) bucket.addFirst(new HashEntry(key, value));
            // add to the first of linkedlist
            rehash();
            return prev;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        try {
            elem_num--;
            keyset.remove(key);
            int index = getBucketIndex(key, buckets.size());
            LinkedList<HashEntry> bucket = buckets.get(index);
            V prev = null;
            if (!bucket.isEmpty()) {
                Iterator<HashEntry> iter = bucket.iterator();
                while (iter.hasNext()) {
                    HashEntry e = iter.next();
                    if (e.key.equals(key)) {
                        prev = e.value;
                        iter.remove();
                    }
                }
            }
            rehash();
            return prev;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (K key : m.keySet()) {
            put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        buckets = new ArrayList<>();
        buckets.add(new LinkedList<HashEntry>());
        //reinitialize
        elem_num = 0;
    }

    @Override
    public Set<K> keySet() {
        return keyset;
    }

    /*
     * It is not required that you implement the values() or entrySet() operations.
     */
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

}

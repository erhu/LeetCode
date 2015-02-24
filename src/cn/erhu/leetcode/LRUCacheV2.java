package cn.erhu.leetcode;

import java.util.HashMap;

public class LRUCacheV2 {

    private HashMap<Integer, Integer> map;
    private int cacheSize;

    public LRUCacheV2(int capacity) {
        this.cacheSize = capacity;
        map = new HashMap<Integer, Integer>(capacity);
    }

    public Integer get(Integer key) {
        Integer v = map.get(key);
        if (v == null) {
            return -1;
        }
        return v;
    }

    public void set(Integer key, Integer value) {
        map.put(key, value);
    }

    /**
     * 本例中不考虑扩容问题
     */
    public static class HashMapX {

        transient Entry[] table;
        transient int size;

        public HashMapX(int initialCapacity) {
            // Find a power of 2 >= initialCapacity
            int capacity = 1;
            while (capacity < initialCapacity) {
                capacity <<= 1;
            }

            table = new Entry[capacity];
        }

        public int get(int key) {
            Entry e = getEntry(key);
            return null == e ? -1 : e.val;
        }

        final Entry getEntry(int key) {
            int hash = hash(key);
            for (Entry e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
                if (e.hash == hash && (e.key == key)) {
                    return e;
                }
            }
            return null;
        }

        public int put(int key, int val) {
            int hash = hash(key);
            int i = indexFor(hash, table.length);

            // 在某个桶中找到此key
            for (Entry e = table[i]; e != null; e = e.next) {
                if (e.hash == hash && e.key == key) {
                    int old = e.val;
                    e.val = val;
                    // todo
                    // e.recordAccess(this)
                    return old;
                }
            }
            addEntry(hash, key, val, i);
            return -1;
        }

        void addEntry(int hash, int key, int val, int bucketIndex) {
            Entry e = table[bucketIndex];
            table[bucketIndex] = new Entry(hash, key, val, e);
            size++;
        }

        static int indexFor(int h, int l) {
            return h & (l - 1);
        }

        final int hash(Object k) {
            int h = 0;
            h ^= k.hashCode();
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Entry e : table) {
                if (e == null) {
                    continue;
                }
                sb.append("(").append(e.key).append(",").append(e.val).append(")\n");
            }
            return sb.toString();
        }

        static class Entry {
            final Integer key;
            Integer val;
            Entry next;
            int hash;

            Entry(int _hash, Integer _key, Integer _value, Entry _next) {
                val = _value;
                next = _next;
                key = _key;
                hash = _hash;
            }
        }
    }
}
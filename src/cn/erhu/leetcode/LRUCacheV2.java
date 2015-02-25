package cn.erhu.leetcode;

/**
 * 本例中不考虑扩容问题
 */
public class LRUCacheV2 {

    // bucket
    transient Entry[] table;
    transient int size;
    int capacity;
    Entry header;
    Entry tailor;

    public LRUCacheV2(int initialCapacity) {
        this.capacity = initialCapacity;
        // Find a power of 2 >= initialCapacity
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }

        table = new Entry[capacity];
        header = new Entry(-1, null, null, null);
        tailor = new Entry(-1, null, null, null);
    }

    public int get(int key) {
        Entry e = getEntry(key);
        removeOneEntryLink(e);
        resetHeader(e);
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

    public int set(int key, int val) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);

        // found key in bucket, set new value
        for (Entry e = table[i]; e != null; e = e.next) {
            if (e.hash == hash && e.key == key) {
                int old = e.val;
                e.val = val;
                removeOneEntryLink(e);
                resetHeader(e);
                return old;
            }
        }
        // not found, add a new entry
        addEntry(hash, key, val, i);
        return -1;
    }

    void addEntry(int hash, int key, int val, int bucketIndex) {

        // The first entry 'e' of the bucket
        Entry e = table[bucketIndex];
        // add the new entry before 'e'
        table[bucketIndex] = new Entry(hash, key, val, e);

        // set header pointer to the new entry
        resetHeader(table[bucketIndex]);

        // init tailor
        if (tailor.before == null) {
            tailor.before = table[bucketIndex];
            table[bucketIndex].after = tailor;
        }
        if (size == capacity) {
            removeLastEntryFromTable();
            size --;
        }
        size++;
    }

    private void resetHeader(Entry new_entry) {
        if (new_entry == null) {
            return;
        }
        new_entry.before = header;
        new_entry.after = header.after;
        if (header.after != null) {
            header.after.before = new_entry;
        }
        header.after = new_entry;
    }

    private void removeOneEntryLink(Entry e) {
        if (e == null) {
            return;
        }
        Entry before = e.before;
        Entry after = e.after;
        if (before != null) {
            before.after = after;
        }
        if (after != null) {
            after.before = before;
        }
        e.after = null;
        e.before = null;
    }

    private void removeLastEntryFromTable() {
        // remove the entry-link before tailor
        if (tailor.before != null) {
            Entry last_node = tailor.before;
            tailor.before = last_node.before;
            if (last_node.before != null) {
                last_node.before.after = tailor;
            }
            last_node.after = null;
            last_node.before = null;
            removeEntryFromTable(last_node);
        }
    }

    private void removeEntryFromTable(Entry entry_to_remove) {
        if (entry_to_remove == null) {
            return;
        }
        int h = hash(entry_to_remove.key);
        int bucket_index = indexFor(h, table.length);
        Entry bucket_pointer = table[bucket_index];
        Entry pre = bucket_pointer;
        while (bucket_pointer != null) {
            if (bucket_pointer.key.equals(entry_to_remove.key) && h == hash(bucket_pointer.key)) {
                if (pre == bucket_pointer) {
                    table[bucket_index] = bucket_pointer.next;
                    break;
                } else {
                    pre.next = bucket_pointer.next;
                    break;
                }
            }
            pre = bucket_pointer;
            bucket_pointer = bucket_pointer.next;
        }

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
            for (; e.next != null; e = e.next) {
                sb.append("(").append(e.key).append(",").append(e.val).append(")\n");
            }
        }
        return sb.toString();
    }

    static class Entry {
        final Integer key;
        Integer val;
        // link for one bucket
        Entry next;
        // link for all entry
        Entry before;
        Entry after;
        int hash;

        Entry(int _hash, Integer _key, Integer _value, Entry _next) {
            val = _value;
            next = _next;
            key = _key;
            hash = _hash;
        }
    }
}

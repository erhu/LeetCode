package cn.erhu.leetcode;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * <p/>
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

    // bucket
    Node[] buckets;
    int size;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int init_capacity) {
        this.capacity = init_capacity;
        // Find a power of 2 >= init_capacity
        int capacity = 1;
        while (capacity < init_capacity) {
            capacity <<= 1;
        }

        buckets = new Node[capacity];
        head = new Node(-1, -1, -1, null);
        tail = new Node(-1, -1, -1, null);
    }

    public int get(int key) {
        Node e = getNode(key);
        moveNode2Head(e);
        return null == e ? -1 : e.val;
    }

    private Node getNode(int key) {
        int hash = hash(key);
        for (Node e = buckets[indexFor(hash, buckets.length)]; e != null; e = e.next) {
            if (e.hash == hash && (e.key == key)) {
                return e;
            }
        }
        return null;
    }

    public int set(int key, int val) {
        int hash = hash(key);
        int i = indexFor(hash, buckets.length);

        // found key in bucket, set new value
        for (Node e = buckets[i]; e != null; e = e.next) {
            if (e.hash == hash && e.key == key) {
                int old = e.val;
                e.val = val;
                moveNode2Head(e);
                return old;
            }
        }
        // not found, add a new node
        addNode(hash, key, val, i);
        return -1;
    }

    private void addNode(int hash, int key, int val, int bucket_idx) {
        // The first node 'e' of the bucket
        Node e = buckets[bucket_idx];
        // add the new node before 'e'
        buckets[bucket_idx] = new Node(hash, key, val, e);

        // set head pointer to the new node
        moveNode2Head(buckets[bucket_idx]);

        // init tail
        if (tail.before == null) {
            tail.before = buckets[bucket_idx];
            buckets[bucket_idx].after = tail;
        }
        if (size == capacity) {
            delLastNode();
            size--;
        }
        size++;
    }

    /**
     * Make head point to e
     *
     * @param e
     */
    private void moveNode2Head(Node e) {
        if (e == null) {
            return;
        }
        delLinksOfNode(e);

        e.before = head;
        e.after = head.after;
        if (head.after != null) {
            head.after.before = e;
        }
        head.after = e;
    }

    /**
     * Remove the links(before after) of node
     *
     * @param e node
     */
    private void delLinksOfNode(Node e) {
        if (e == null) {
            return;
        }
        Node before = e.before;
        Node after = e.after;
        if (before != null) {
            before.after = after;
        }
        if (after != null) {
            after.before = before;
        }
        e.after = null;
        e.before = null;
    }

    /**
     * Del the eldest node
     */
    private void delLastNode() {
        // del the links(before, after) of node before tail
        if (tail.before != null) {
            Node last = tail.before;
            tail.before = last.before;
            if (last.before != null) {
                last.before.after = tail;
            }
            last.after = null;
            last.before = null;

            delNodeFromBuckets(last);
        }
    }

    /**
     * Del node from bucket (include link and value)
     *
     * @param node
     */
    private void delNodeFromBuckets(Node node) {
        if (node == null) {
            return;
        }
        int h = hash(node.key);
        int bucket_idx = indexFor(h, buckets.length);
        Node pointer = buckets[bucket_idx];
        Node pre = pointer;

        while (pointer != null) {
            if (pointer.key == node.key && h == hash(pointer.key)) {
                if (pre == pointer) {
                    // the node to del is the first node of a bucket
                    buckets[bucket_idx] = pointer.next;
                    break;
                } else {
                    // del pointer
                    pre.next = pointer.next;
                    break;
                }
            }
            pre = pointer;
            pointer = pointer.next;
        }
    }

    private int indexFor(int h, int l) {
        return h & (l - 1);
    }

    private int hash(Object k) {
        int h = 0;
        h ^= k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node e : buckets) {
            if (e == null) {
                continue;
            }
            for (; e.next != null; e = e.next) {
                sb.append("(").append(e.key).append(",").append(e.val).append(")\n");
            }
        }
        return sb.toString();
    }

    private static class Node {
        final int key;
        int val;
        // link for one bucket
        Node next;
        // link for all node
        Node before;
        Node after;
        int hash;

        Node(int _hash, int _key, int _value, Node _next) {
            val = _value;
            next = _next;
            key = _key;
            hash = _hash;
        }
    }
}

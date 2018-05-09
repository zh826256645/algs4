package com.three.one;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 基于链表的顺序查找
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private int size = 0;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;    // 命中
            }
        }
        return null;    // 未命中
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;    // 命中
            }
        }
        first = new Node(key, val, first);    // 未命中
        size ++;
    }

    public int size() {
        return size;
    }

    public Value delete(Key key) {
        Node lastNode = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                if(lastNode != null) {
                    lastNode.next = x.next;
                } else {
                    first = x.next;
                }
                return x.val;
            }
            lastNode = x;
        }
        return null;
    }

    public boolean containsKey(Key key) {
        Value val = get(key);
        return val != null;
    }

    public HashSet<Key> keySet() {
        HashSet<Key> keys = new HashSet<>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }
}

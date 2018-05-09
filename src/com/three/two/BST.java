package com.three.two;

import java.util.HashSet;
import java.util.Queue;

/**
 * 基于二叉查找树的符号表
 */
public class BST <Key extends Comparable<Key>, Value>{

    private Node root;    // 根结点

    public HashSet<Key> keys;

    private class Node {
        private Key key;    // 键
        private Value val;    // 值
        private Node left, right;    // 左右子树
        private int N;    // 以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int N) {
            this.key = key; this.val = val; this.N = N;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // 在以 x 为根结点的子树中查找并返回 key 所对应的值
        // 如果找不到则返回 null
        if (x == null) {
            return null;
        } else {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) {
                return get(x.left, key);
            } else if (cmp > 0) {
                return get(x.right, key);
            } else {
                return x.val;
            }
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        // 如果 key 存在于以 x 为根结点的子树中则更新它的值
        // 否则将以 key 和 val 为键值对的新结点插入到该子树中
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean containsKey(Key key) {
        return get(key) != null;
    }

    public HashSet<Key> keySet() {
        keys = new HashSet<>();
        keySet(root);
        return keys;
    }

    private void keySet(Node x) {
        if (x == null) {
            return;
        }
        keys.add(x.key);
        keySet(x.left);
        keySet(x.right);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return min(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        // 返回排名位 k 的结点
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        // 返回以 x 为根结点的子树中小于 x.key 的键的数量
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        HashSet<Key> set = new HashSet<>();
        keys(root, set, lo, hi);
        return set;
    }

    private void keys(Node x, HashSet<Key> set, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, set, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) set.add(x.key);
        if (cmphi > 0) keys(x.right, set, lo, hi);
    }

}

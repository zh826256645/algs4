package com.three.two;

import java.util.HashSet;

public class ReadBlackBST<Key extends Comparable<Key>, Value> {

    private Node root;

    public HashSet<Key> keys;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;            // 键
        Value val;          // 相关联的值
        Node left, right;   // 左右子树
        int N;              // 这课子树中的结点总数
        boolean color;      // 由其父节点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        return x != null && x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(Node x) {
        return x == null ? 0 : x.N;
    }

    public void put(Key key, Value val) {
        // 查找 key，找到则更新其值，否则为它新建一个结点
        root = put(root, key, val);
        root.color = BLACK;
    }

    public Node put(Node h, Key key, Value val) {
        if (h == null) {
            // 标准的插入炒作，和父结点用红链接相连
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public boolean containsKey(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) { return get(root, key); }

    public Value get(Node h, Key key) {
        if (h == null) {
            return null;
        } else {
            int cmp = key.compareTo(h.key);
            if (cmp < 0) return get(h.left, key);
            else if (cmp > 0) return get(h.right, key);
            else return h.val;
        }
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

    private Node moveRedLeft(Node h) {
        // 假设结点 h 为红色，h.left 和 h.left.left 都是黑色
        // 将 h.left 或者 h.left 的子结点之一变红
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

}

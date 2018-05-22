package com.three.five;

import com.three.one.SequentialSearchST;

/**
 * 基于拉链法的散列表
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {

    private int N;    // 键值队总数
    private int M;    // 散列表的大小
    private SequentialSearchST<Key, Value>[] st;    // 存放链表对象的数组

    private SeparateChainingHashST(){
        this(997);
    }

    public SeparateChainingHashST(int M) {
        // 创建 M 条链表
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
}

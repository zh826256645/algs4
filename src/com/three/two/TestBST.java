package com.three.two;

import com.all.utils.StdIn;


public class TestBST {

    public static void main(String[] args) {
        // 最小键长
        long startTime=System.currentTimeMillis();

        int minlen = Integer.parseInt(args[0]);

        BST<String, Integer> st = new BST<>();
        while (!StdIn.isEmpty()) {
            // 构造符号表并统计频率
            String word = StdIn.readString();
            if (word.length() < minlen) continue; // 忽略较短的单词
            if (!st.containsKey(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }

        System.out.println("aaabusiness - business: " + st.keys("aaabusiness", "business"));

//        for (int i = 0; i <= 5; i++) {
//            String key = st.select(i);
//            System.out.println("The No." + i + " is " + key + ",size is "  + st.get(key));
//        }

//        st.delete("business");
//
//        // 找出出现频率最高的单词
//        String max = " ";
//
//        st.put(max, 0);
//        for (String word : st.keySet()) {
//
//            if (word == null) continue;
//
//            if (st.get(word) > st.get(max)) {
//                max = word;
//            }
//        }
//        System.out.println(max + " " + st.get(max));

        System.out.println("run time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}

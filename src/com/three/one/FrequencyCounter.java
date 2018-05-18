package com.three.one;

import com.all.utils.StdIn;
import com.three.two.BST;
import com.three.two.ReadBlackBST;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;

/**
 * 从标准输入中得到的一列字符串并记录每个字符串的出现次数
 * 然后便利所有键并找出出现频率最高的键
 */
public class FrequencyCounter {

    public static void main(String[] args) {
        // 最小键长
        long startTime=System.currentTimeMillis();

        int minlen = Integer.parseInt(args[0]);
//        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
//        BinarySearchST<String, Integer> st = new BinarySearchST<>(2000);
//        HashMap<String, Integer> st = new HashMap<>();
//        BST<String, Integer> st = new BST<>();
        ReadBlackBST<String, Integer> st = new ReadBlackBST<>();
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

        // 找出出现频率最高的单词
        String max = " ";

        st.put(max, 0);
        for (String word : st.keySet()) {
//            System.out.println(word + " " + st.get(word));
            if (word == null) continue;

            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        System.out.println(max + " " + st.get(max));

        System.out.println("run time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}

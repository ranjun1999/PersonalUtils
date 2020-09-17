package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.*;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 *
 * @Author: ranjun
 * @Date: 2019/12/6 21:43
 */
public class 串联所有单词的子串 {

    /**
     *1. 暴力法
     * 遍历所有子串，检查是否为words串联组成
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<String> wordsList = new ArrayList<>();

        for (String word : words) {
            wordsList.add(word);
        }


        List<Integer> result = new ArrayList<>();

        if (s == null || s.equals("")) {
            return result;
        }

        if (words.length < 1) {
            return result;
        }


        //每个单词的长度
        int wordLength = words[0].length();

        int subLength = words.length * wordLength;


        if (s.length() < subLength) {
            return result;
        }

        int i = 0;
        while (i <= (s.length() - subLength)) {
            //截取子串
            String subString = s.substring(i,(subLength + i));
            System.out.println(subString);
            if (isSubstring(subString, wordsList)) {
                result.add(i);
            }
            i++;
        }

        return result;
    }

    public static boolean isSubstring(String s, List<String> words) {
        List<String> wordClone = new ArrayList<>(words);
        int wordLength = words.get(0).length();

        for (int i = 0; i < s.length(); i = i + wordLength) {
            String word = s.substring(i,(wordLength + i));
            if (!words.contains(word)) {
                return false;
            }
            wordClone.remove(word);
        }
        return wordClone.size() == 0;
    }

    public List<Integer> findSubString(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        //单词数量
        int wordNum = words.length;

        if (wordNum == 0) {
            return res;
        }
        //单词长度
        int wordLen = words[0].length();


        //保存所有需要的字符串
        HashMap<String, Integer> needs = new HashMap<>();
        for (String word : words) {
            needs.put(word, needs.getOrDefault(word,0) + 1);
        }

        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //保存当前扫描的字符含有的单词
            HashMap<String,Integer> subWords = new HashMap<>();

            int num = 0;
            //判断该子串是否符号
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1)*wordLen);
                if (needs.containsKey(word)) {

                    subWords.put(word,subWords.getOrDefault(word,0) + 1);
                    //判断当前单词的value和needs中的value1,若大于则表示当前子串不是我们要找的，跳过。
                    if (subWords.get(word) > needs.get(word)) {
                        break;
                    }
                }else break;;
                num ++;
            }
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }


    /**
     * 滑动窗口法
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring_2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();

        //一个单词的长度
        int one_word = words[0].length();
        //单词数量
        int word_num = words.length;

//        int all_len = one_word * word_num;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //从0开始，每次移动一个单词的长度
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;

            HashMap<String, Integer> tmp_map = new HashMap<>();

            while (right + one_word <= s.length()) {

                String w = s.substring(right, right + one_word);

                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);

                right += one_word;

                count++;

                //如果当前子串符合needs的要求，继续进行下一次扫描；若不符合要求，则左指针移动到下一个单词
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if (count == word_num) res.add(left);
            }
        }

        return res;
    }

    public static void test() {

        System.out.println(1);

        try {
            System.out.println(2);
            throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println(3);
        }

        System.out.println("finish");
    }


    public static void main(String[] args) {
//        System.out.println(word.size());
        test();
    }


}

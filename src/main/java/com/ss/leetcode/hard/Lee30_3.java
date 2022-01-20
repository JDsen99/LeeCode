package com.ss.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Senn
 * @create 2022/1/20 9:38
 */
public class Lee30_3 {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> wordMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (String word : words) {
            Integer value = wordMap.getOrDefault(word, 0);
            wordMap.put(word,value + 1);
        }
        int wordLen = words[0].length();

        int len = words.length;

        for (int i = 0; i < s.length() - wordLen * len + 1; i++) {
            Map<String,Integer> hasWordMap = new HashMap<>();

            int num = 0;
            while(num < len) {
                String word = s.substring(i + num * wordLen,i + (num + 1) * wordLen);
                if (wordMap.containsKey(word)) {
                    int value = hasWordMap.getOrDefault(word,0);
                    hasWordMap.put(word,value + 1);
                    if (hasWordMap.get(word) > wordMap.get(word)) {
                        break;
                    }
                }else {
                    break;
                }
                num++;
            }
            if (num == len) {
                res.add(i);
            }
        }
        return res;
    }
}

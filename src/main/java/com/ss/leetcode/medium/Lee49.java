package com.ss.leetcode.medium;

import java.util.*;

/**
 * @author Senn
 * @create 2022/1/27 10:54
 */
public class Lee49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            List<String> list = map.getOrDefault(string, new ArrayList<>());
            list.add(str);
            map.put(string,list);
        }
        return new ArrayList<>(map.values());
    }
}

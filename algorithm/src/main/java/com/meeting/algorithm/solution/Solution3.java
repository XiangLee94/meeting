package com.meeting.algorithm.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int begin = 0;
        int last = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (last < s.length()) {
            Character c = s.charAt(last++);
            if (map.containsKey(c)) {
                Integer index = map.get(c);
                for (int i = begin; i < index; i++) {
                    map.remove(s.charAt(i));
                }
                begin = index;
            }
            map.put(c, last);
            int size = map.size();
            max = max > size ? max : size;
        }
        return max;
    }
}

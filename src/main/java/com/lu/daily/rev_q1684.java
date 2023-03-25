package com.lu.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *
 * @author sheldon
 * @date 2022-11-08
 */
public class rev_q1684 {

    public int countConsistentStrings1(String allowed, String[] words){



        return 0;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = allowed.toCharArray();
        List<Character> base = new ArrayList<>();
        for (char aChar : chars) {
            base.add(aChar);
        }
        int count = 0;
        for (String word : words) {
            char[] chars1 = word.toCharArray();
            HashSet<Character> objects = new HashSet<>();
            for (char c : chars1) {
                objects.add(c);
            }
            if (base.containsAll(objects)){
                count++;
            }
        }
        return count;
    }

}

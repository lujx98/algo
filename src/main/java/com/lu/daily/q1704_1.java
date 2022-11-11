package com.lu.daily;

import org.junit.Test;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 *
 * @author sheldon
 * @date 2022-11-11
 */
public class q1704_1 {

    @Test
    public void test() {
        System.out.println(halvesAreAlike("book"));
    }

    private static int _MASK = 0;

    static {
        _MASK |= 1 << ('a' - 'a');
        _MASK |= 1 << ('e' - 'a');
        _MASK |= 1 << ('i' - 'a');
        _MASK |= 1 << ('o' - 'a');
        _MASK |= 1 << ('u' - 'a');
        _MASK |= 1 << ('A' - 'a');
        _MASK |= 1 << ('E' - 'a');
        _MASK |= 1 << ('I' - 'a');
        _MASK |= 1 << ('O' - 'a');
        _MASK |= 1 << ('U' - 'a');
    }

    public boolean halvesAreAlike(String s) {
        int count = 0;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if ((1 & (_MASK >> (s.charAt(left) - 'a'))) == 1) count++;
            if ((1 & (_MASK >> (s.charAt(right) - 'a'))) == 1) count--;
            left++;
            right--;
        }
        return count == 0;
    }

}

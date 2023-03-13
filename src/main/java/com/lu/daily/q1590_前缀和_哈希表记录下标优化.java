package com.lu.daily;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-03-10
 */
public class q1590_前缀和_哈希表记录下标优化 {

    @Test
    public void test() {
        System.out.println(minSubarray(new int[]{4, 4, 2}, 7));
    }

    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i)
            s[i + 1] = (s[i] + nums[i]) % p;
        int x = s[n];
        if (x == 0) return 0; // 移除空子数组（这行可以不要）

        Map<Integer, Integer> last = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n; ++i) {
            last.put(s[i], i);
            // 如果不存在，-n 可以保证 i-j >= n
            int j = last.getOrDefault((s[i] - x + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < n ? ans : -1;
    }
}

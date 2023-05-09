package com.lu.all;

/**
 * @author sheldon
 * @date 2023-03-26
 */
public class 双指针_滑动窗口_同向双指针_q713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, left = 0, prod = 1;
        for (int right = 0; right < nums.length; ++right) {
            prod *= nums[right];
            while (prod >= k) // 不满足要求
                prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    //if (k <= 1)
    //            return 0;
    //        int n = nums.length, ans = 0, prod = 1, left = 0;
    //        for (int right = 0; right < n; ++right) {
    //            prod *= nums[right];
    //            while (prod >= k) // 不满足要求
    //                prod /= nums[left++];
    //            ans += right - left + 1;
    //        }
    //        return ans;
    //
    //作者：灵茶山艾府
    //链接：https://leetcode.cn/problems/subarray-product-less-than-k/solutions/1959538/xia-biao-zong-suan-cuo-qing-kan-zhe-by-e-jebq/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}

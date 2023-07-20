package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-27
 */
public class 动态规划_子数组_记忆化搜索_q1186_删除一次得到子数组最大和 {

    @Test
    public void test() {
        String  s ="https://graph.facebook.com/407056366783240/activities?event=CUSTOM_APP_EVENTS&advertiser_tracking_enabled=0&application_tracking_enabled=0&custom_events=%5B%7B%22userId%22%3A30246023&custom_events=%22deviceFingerprint%22%3A%221636618387499d8b49991533eb261318d077e821f58b4371%22&custom_events=%22_eventName%22%3A%22CREDIT_ORDER_APPROVED%22%7D%5D HTTP/1.1";
        s = s.replaceAll("%3D", "=")
                .replaceAll("%5B", "[")
                .replaceAll("%7B", "{")
                .replaceAll("%7D", "}")
                .replaceAll("%5D", "]")
                .replaceAll("%22", "\"")
                .replaceAll("%2C", ",")
                .replaceAll("%3A", ":");
        System.out.println(s);
    }


    private int[] arr;
    private int[][] memo;

    public int maximumSum(int[] arr) {
        this.arr = arr;
        this.memo = new int[arr.length][2];
        for (int[] ints : this.memo) {
            Arrays.fill(ints, -1);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(i, 0));
        }
        return res;
    }

    private int dfs(int i, int deled) {
        if (i == 0) {
            return arr[0];
        }
        if (memo[i][deled] != -1) {
            return memo[i][deled];
        }
        int res = arr[i];
        res = Math.max(res, arr[i] + dfs(i - 1, deled));
        if (arr[i] < 0 && deled == 0) {
            res = Math.max(res, dfs(i - 1, 1));
        }
        return memo[i][deled] = res;
    }

}

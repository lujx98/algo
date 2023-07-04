package com.lu.all;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sheldon
 * @date 2023-06-27
 */
public class q1186 {

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
        int res = Integer.MIN_VALUE;
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(Math.max(dfs(0, 1), res), dfs(0, 0));
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (i > arr.length - 1) {
            return Integer.MIN_VALUE;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        if (j == 0) {
            return 0;
        } else {
            return memo[i][j] = Math.max(dfs(i + 1, 1) + arr[i], dfs(i + 1, 0));
        }
    }

}

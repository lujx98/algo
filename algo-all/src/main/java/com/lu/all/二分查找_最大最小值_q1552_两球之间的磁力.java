package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-20
 */
public class 二分查找_最大最小值_q1552_两球之间的磁力 {

    @Test
    public void test() {
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
    }

    public int maxDistance(int[] position, int m) {


        return 0;
    }

//    public int maxDistance(int[] position, int m) {
//        Arrays.sort(position);
//        int left = 1;
//        int right = position[position.length - 1] - position[0];
//        int returnInt = 0;
//        while (left <= right) {
//            int res = left + (right - left) / 2;
//            if (check(res, position, m)) {
//                returnInt = res;
//                left = res + 1;
//            } else {
//                right = res - 1;
//            }
//        }
//        return returnInt;
//    }

//    public int maxDistance(int[] position, int m) {
//        Arrays.sort(position);
//        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (check(mid, position, m)) {
//                ans = mid;
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return ans;
//    }

    /**
     * 贪心
     * true表示最小磁力能凑m组
     *
     * @param position
     * @param res
     * @param m
     * @return
     */
    private boolean check(int res, int[] position, int m) {
        int temp = 0;
        for (int i = 0; i < position.length; i++) {
            if (i != 0) {
                temp += (position[i] - position[i - 1]);
                if (temp >= res) {
                    m--;
                    temp = 0;
                }
            }
        }
        return m <= 1;
    }

//    public boolean check(int x, int[] position, int m) {
//        int pre = position[0], cnt = 1;
//        for (int i = 1; i < position.length; ++i) {
//            if (position[i] - pre >= x) {
//                pre = position[i];
//                cnt += 1;
//            }
//        }
//        return cnt >= m;
//    }

}

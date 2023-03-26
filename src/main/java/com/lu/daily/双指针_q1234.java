package com.lu.daily;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-02-13
 */
public class 双指针_q1234 {

    @Test
    public void test() {
        System.out.println(balancedString("QQQQ"));
    }

    public int balancedString1(String s) {
        int[] arr = new int['X'];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int tar = s.length() / 4;
        if (arr['Q'] == arr['W'] && arr['W'] == arr['E'] && arr['E'] == arr['R']) {
            return 0;
        }

        arr['Q'] -= tar;
        arr['W'] -= tar;
        arr['E'] -= tar;
        arr['R'] -= tar;

        int ans = Integer.MAX_VALUE, left = 0;
        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right)]--;
            while (arr['Q'] <= 0 && arr['W'] <= 0 && arr['E'] <= 0 && arr['R'] <= 0) {
                ans = Math.min(ans, right - left + 1);
                ++arr[s.charAt(left++)];
            }
        }

        return ans;
    }

    public int balancedString(String s) {
        int a = s.length() / 4;
        int qCount = -a;
        int wCount = -a;
        int eCount = -a;
        int rCount = -a;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'Q':
                    qCount++;
                    break;
                case 'W':
                    wCount++;
                    break;
                case 'E':
                    eCount++;
                    break;
                case 'R':
                    rCount++;
                    break;
                default:
                    break;
            }
        }
        int[] arr = new int[]{
                Math.max(qCount, 0), Math.max(wCount, 0), Math.max(eCount, 0), Math.max(rCount, 0)
        };

        if (qCount == wCount && wCount == eCount && eCount == rCount) {
            return 0;
        }

        int ans = Integer.MAX_VALUE, left = 0;
        for (int right = 0; right < s.toCharArray().length; right++) {
            switch (s.charAt(right)) {
                case 'Q':
                    arr[0]--;
                    break;
                case 'W':
                    arr[1]--;
                    break;
                case 'E':
                    arr[2]--;
                    break;
                case 'R':
                    arr[3]--;
                    break;
                default:
                    break;
            }
            if (canBe(arr)) {
                while (canBe(arr)) {
                    switch (s.charAt(left++)) {
                        case 'Q':
                            arr[0]++;
                            break;
                        case 'W':
                            arr[1]++;
                            break;
                        case 'E':
                            arr[2]++;
                            break;
                        case 'R':
                            arr[3]++;
                            break;
                        default:
                            break;
                    }
                }
                ans = Math.min(ans, right - left + 2);
            }
        }

        return ans;
    }

    private boolean canBe(int[] arr) {
        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

}

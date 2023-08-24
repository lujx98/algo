package com.lu.all;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-08-24
 */
public class 单调栈_快速幂_贡献法_质因数分解_q2818_操作使得分最大 {

    @Test
    public void test() {
        System.out.println(maximumScore(Arrays.asList(3289, 2832, 14858, 22011), 6));
    }

    private final int MAX = (int) 1e5 + 1;
    private final int[] OMEGA = new int[MAX];
    private final int MOD = (int) 1E9 + 7;

    {
        for (int i = 2; i < OMEGA.length; i++) {
            if (OMEGA[i] == 0) {
                for (int j = i; j < OMEGA.length; j += i) {
                    OMEGA[j]++;
                }
            }
        }
    }

    public int maximumScore(List<Integer> nums, int k) {
        int[] toLeft = new int[nums.size()];
        int[] toRight = new int[nums.size()];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.size(); i++) {
            while (!deque.isEmpty() && OMEGA[nums.get(deque.peek())] < OMEGA[nums.get(i)]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                toLeft[i] = -1;
            } else {
                toLeft[i] = deque.peek();
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!deque.isEmpty() && OMEGA[nums.get(deque.peek())] <= OMEGA[nums.get(i)]) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                toRight[i] = nums.size();
            } else {
                toRight[i] = deque.peek();
            }
            deque.push(i);
        }

        Integer[] sor = new Integer[nums.size()];
        for (int i = 0; i < sor.length; i++) {
            sor[i] = i;
        }

        Arrays.sort(sor, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums.get(o2) - nums.get(o1);
            }
        });

        long res = 1;
        for (int i = 0; i < sor.length; i++) {
            Integer index = sor[i];
            long range = (long) (index - toLeft[index]) * (toRight[index] - index);
            if (range >= k) {
                res = res * pow(nums.get(index), k) % MOD;
                break;
            }
            res = res * pow(nums.get(index), (int) range) % MOD;
            k -= range;
        }
        return (int) res % MOD;
    }

    private long pow(long x, int n) {
        long res = 1L;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

}

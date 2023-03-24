package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sheldon
 * @date 2023-01-02
 */
public class 优先队列_q1801 {

    @Test
    public void test() {
        System.out.println(getNumberOfBacklogOrders
                (new int[][]{new int[]{23, 8, 0}, new int[]{28, 29, 1}, new int[]{11, 30, 1}, new int[]{30, 25, 0}, new int[]{26, 9, 0}, new int[]{3, 21, 0}
                        , new int[]{28, 19, 1}, new int[]{19, 30, 0}, new int[]{20, 9, 1}, new int[]{17, 6, 0}}));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        int MOD = (int) 1e9 + 7;
        PriorityQueue<Integer[]> buyQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<Integer[]> sellQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            if (order[2] == 1) {
                //表示为卖单
                //1.先匹配买单
                while (amount > 0) {
                    Integer[] peek = buyQueue.peek();
                    //如果卖出价格高于买入价格就入队
                    if (peek == null || price > peek[0]) {
                        sellQueue.offer(new Integer[]{price, amount, 0});
                        break;
                    }
                    if (peek[1] < amount) {
                        //没有完全匹配
                        Integer[] poll = buyQueue.poll();
                        amount -= poll[1];
                    } else if (peek[1] > amount) {
                        //完全匹配
                        peek[1] -= amount;
                        amount = 0;
                    } else {
                        buyQueue.poll();
                        amount = 0;
                    }
                }
            } else {
                //表示为买单
                while (amount > 0) {
                    Integer[] peek = sellQueue.peek();
                    //如果卖出价格高于买入价格就入队
                    if (peek == null || price < peek[0]) {
                        buyQueue.offer(new Integer[]{price, amount, 0});
                        break;
                    }
                    if (peek[1] < amount) {
                        //没有完全匹配
                        Integer[] poll = sellQueue.poll();
                        amount -= poll[1];
                    } else if (peek[1] > amount) {
                        //完全匹配
                        peek[1] -= amount;
                        amount = 0;
                    } else {
                        sellQueue.poll();
                        amount = 0;
                    }
                }
            }
        }

        int total = 0;
        for (PriorityQueue<Integer[]> pq : Arrays.asList(buyQueue, sellQueue)) {
            while (!pq.isEmpty()) {
                Integer[] order = pq.poll();
                total = (total + order[1]) % MOD;
            }
        }
        return total;
    }

    public int getNumberOfBacklogOrders1(int[][] orders) {
        final int MOD = 1000000007;
        PriorityQueue<int[]> buyOrders = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price) {
                    int[] sellOrder = sellOrders.poll();
                    int sellAmount = Math.min(amount, sellOrder[1]);
                    amount -= sellAmount;
                    sellOrder[1] -= sellAmount;
                    if (sellOrder[1] > 0) {
                        sellOrders.offer(sellOrder);
                    }
                }
                if (amount > 0) {
                    buyOrders.offer(new int[]{price, amount});
                }
            } else {
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price) {
                    int[] buyOrder = buyOrders.poll();
                    int buyAmount = Math.min(amount, buyOrder[1]);
                    amount -= buyAmount;
                    buyOrder[1] -= buyAmount;
                    if (buyOrder[1] > 0) {
                        buyOrders.offer(buyOrder);
                    }
                }
                if (amount > 0) {
                    sellOrders.offer(new int[]{price, amount});
                }
            }
        }
        int total = 0;
        for (PriorityQueue<int[]> pq : Arrays.asList(buyOrders, sellOrders)) {
            while (!pq.isEmpty()) {
                int[] order = pq.poll();
                total = (total + order[1]) % MOD;
            }
        }
        return total;
    }

}

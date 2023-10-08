package com.lu.all;

import java.util.TreeMap;

/**
 * @author sheldon
 * @date 2023-10-08
 */
public class 哈希表_q2034_股票价格波动 {

    static class StockPrice {

        private final TreeMap<Integer, Integer> map = new TreeMap<>();
        private final TreeMap<Integer, Integer> priceMap = new TreeMap<>();

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if (map.containsKey(timestamp)) {
                Integer oldPrice = map.get(timestamp);
                priceMap.merge(oldPrice, -1, Integer::sum);
                if (priceMap.get(oldPrice) == 0) {
                    priceMap.remove(oldPrice);
                }
                map.put(timestamp, price);
                priceMap.merge(price, 1, Integer::sum);
            } else {
                map.put(timestamp, price);
                priceMap.merge(price, 1, Integer::sum);
            }
        }

        public int current() {
            return map.lastEntry().getValue();
        }

        public int maximum() {
            return priceMap.lastKey();
        }

        public int minimum() {
            return priceMap.firstKey();
        }

    }

}

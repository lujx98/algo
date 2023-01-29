package com.lu.daily;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sheldon
 * @date 2023-01-08
 */
public class q2526_1 {

    @Test
    public void test() {
        DataStream dataStream = new DataStream(1,2);
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(2));
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(1));
        System.out.println(dataStream.consec(1));
    }

    private static class DataStream {
        int k;
        private List<Integer> list = new ArrayList<>();

        public DataStream(int value, int k) {
            this.k = k;
            list.add(value);
        }

        public boolean consec(int num) {
            list.add(num);
            boolean asd = asd(num);
            return asd;
        }

        private boolean asd(int num) {
            int size = list.size();
            if (size < k) {
                return false;
            }
            for (int i = size - 1; i >= size - k; i--) {
                if (!Objects.equals(list.get(i), num)) {
                    return false;
                }
            }
            return true;
        }

    }

}

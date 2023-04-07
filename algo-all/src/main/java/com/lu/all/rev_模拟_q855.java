package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2022-12-31
 */
public class rev_模拟_q855 {

    @Test
    public void test() {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }

    static class ExamRoom {

        private int div;
        private boolean[] mask;

        public ExamRoom(int n) {
            mask = new boolean[n];
            div = n;
        }

        public int seat() {
            int temp = 0;
            while (true) {
                if (temp >= mask.length) {
                    div /= 2;
                    temp = div;
                }
                //如果没有人做过
                if (mask[temp]) {
                    //坐上去
                    mask[temp] = true;
                    break;
                } else {
                    //如果座位上有人，+div
                    temp += div;
                }
            }
            return temp;
        }

        public void leave(int p) {
            mask[p] = false;
        }
    }

}

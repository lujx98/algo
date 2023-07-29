package com.lu.all;

import java.util.HashSet;

/**
 * @author sheldon
 * @date 2023-07-19
 */
public class 模拟_q874_模拟行走机器人 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        HashSet<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }

        int xF = 0, yF = 1;
        boolean xM = false, yM = false;

        int res = 0;
        for (int command : commands) {
            int xD = x, yD = y;
            if (command > 0) {
                while (command-- != 0) {
                    int xTemp = xD + xF * (xM ? -1 : 1);
                    int yTemp = yD + yF * (yM ? -1 : 1);
                    if (obs.contains(xTemp + "," + yTemp)) {
                        break;
                    }
                    xD = xTemp;
                    yD = yTemp;
                }
                res = Math.max(res, xD * xD + yD * yD);
                x = xD;
                y = yD;
            } else {
                if (command == -1) {
                    if (!xM && xF == 1) {
                        yM = true;
                    } else if (yM) {
                        xM = true;
                        yM = false;
                    } else if (xM) {
                        xM = false;
                    }
                } else {
                    if (!yM && yF == 1) {
                        xM = true;
                    } else if (xM) {
                        xM = false;
                        yM = true;
                    } else if (yM) {
                        yM = false;
                    }
                }

                yF ^= 1;
                xF ^= 1;
            }

        }
        return res;
    }

}

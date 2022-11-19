package com.lu.daily;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sheldon
 * @date 2022-11-19
 */
public class q1732_1 {

    public int largestAltitude(int[] gain) {
        int res = 0;
        int altitude = 0;
        for (int i : gain) {
            altitude += i;
            res = Math.max(res, altitude);
        }
        return res;
    }

}

package com.lu.daily;


import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @date 2023-02-09
 */
public class q1797_哈希表_设计一个验证系统过期续期与统计 {

    static class AuthenticationManager {
        
        int timeToLive;
        Map<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new HashMap<String, Integer>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.getOrDefault(tokenId, 0) > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            for (int time : map.values()) {
                if (time > currentTime) {
                    res++;
                }
            }
            return res;
        }

    }

}

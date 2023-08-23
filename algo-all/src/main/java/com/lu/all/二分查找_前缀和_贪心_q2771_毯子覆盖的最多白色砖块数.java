package com.lu.all;

import com.lu.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sheldon
 * @date 2023-08-23
 */
public class 二分查找_前缀和_贪心_q2771_毯子覆盖的最多白色砖块数 {

    @Test
    public void test() {
        System.out.println(maximumWhiteTiles(ArrayUtils.makeIntArraysByString("[[8051,8057],[8074,8089],[7994,7995],[7969,7987],[8013,8020],[8123,8139],[7930,7950],[8096,8104],[7917,7925],[8027,8035],[8003,8011]]"), 9854));
    }

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int cover = 0;
        int[] prefix = new int[tiles.length + 1];
        for (int i = 1; i <= tiles.length; i++) {
            prefix[i] = prefix[i - 1] + (tiles[i - 1][1] - tiles[i - 1][0] + 1);
        }
        for (int i = 0; i < tiles.length; i++) {
            int start = tiles[i][0], end = start + carpetLen - 1;
            int curCover = 0;
            if (end <= tiles[i][1]) {
                return carpetLen;
            } else {
                int left = i + 1, right = tiles.length - 1;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (check(tiles, mid, end)) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left < tiles.length && end >= tiles[left][0]) {
                    curCover += ((Math.min(end, tiles[left][1])) - tiles[left][0] + 1);
                }
                curCover += prefix[left] - prefix[i];
            }
            cover = Math.max(cover, curCover);
            if (end >= tiles[tiles.length - 1][1]) {
                break;
            }
        }
        return cover;
    }

    private boolean check(int[][] tiles, int mid, int end) {
        int[] cur = tiles[mid];
        return cur[1] >= end;
    }

}

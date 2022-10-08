package com.lu.dmsxl.uncatagorized;

/**
 * @author sheldon
 * @date 2022-09-18
 */
public class q88Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int nn;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                nn = nums2[p2++];
            } else if (p2 == n) {
                nn = nums1[p1++];
            }else if (nums1[p1] >= nums2[p2]) {
                nn = nums2[p2++];
            } else {
                nn = nums1[p1++];
            }
            sort[p1 + p2 - 1] = nn;
        }
        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
    }

}

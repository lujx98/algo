package com.lu.algo.binary.easy;


/**
 *
 * @author sheldon
 * @date 2022-03-15
 */
public class q278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int right = n,left = 0;
        int ans = right;
        while(right>=left){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)&&isBadVersion(mid-1)){
                right =mid-1;

            }else
//                if (!isBadVersion(mid)&&!isBadVersion(mid-1))
            {
                //int 类型在最后会栈溢出
                left=mid+1;
                ans=mid;
            }
        }
        return ans;
    }

    public static boolean isBadVersion(int version){
        if (version >= 4){
            return true;
        }
        return false;
    }

}

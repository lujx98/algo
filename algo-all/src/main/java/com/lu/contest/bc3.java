package com.lu.contest;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author sheldon
 * @date 2023-09-02
 */
public class bc3 {

    @Test
    public void test() {
        System.out.println(maxSum(Arrays.asList(996021492,996021492,973489433,66259330,554129007,713784351,646092981,328987029,469368828,685679486,66259330,165954500,731567840,595800464,552439059,14673238,157622945,521321042,386913607,733723177,330475939,462727944,69696035,958945846,648914457,627088742,363551051,50748590,400980660,674779765,439950964,613843311,385212079,725525766,813504429,385212079,66563232,578031878,935017574,554725813,456892672,245308625,626768145,270964388,554725813,768296675,676923124,939689721,115905765,625193590,717796816,27972217,277242430,768296675,480860474,659230631,570682291,601689140,955632265,767424000,251696645,675750691,767424000,251696645,767424000,675750691,675750691,251696645), 8, 8));
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = k - 2;
        long sum = 0;
        for (int i = 0; i <= right; i++) {
            map.merge(nums.get(i), 1, Integer::sum);
            sum += nums.get(i);
        }
        right++;
        long res = 0;
        for (; right < nums.size(); right++, left++) {
            sum += nums.get(right);
            map.merge(nums.get(right), 1, Integer::sum);
            if (map.size() >= m) {
                res = Math.max(res, sum);
            }
            map.merge(nums.get(left), -1, Integer::sum);
            if (map.get(nums.get(left)) == 0) {
                map.remove(nums.get(left));
            }
            sum -= nums.get(left);
        }
        return res;
    }

}

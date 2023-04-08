package com.lu.all;


import com.lu.utils.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-04-08
 */
public class rev_q1125 {

    @Test
    public void test() {
        System.out.println(Arrays.toString(smallestSufficientTeam(new String[]{"gvp","jgpzzicdvgxlfix","kqcrfwerywbwi","jzukdzrfgvdbrunw","k"},
                StringUtils.parse2DList("[[],[],[],[],[\"jgpzzicdvgxlfix\"],[\"jgpzzicdvgxlfix\",\"k\"],[\"jgpzzicdvgxlfix\",\"kqcrfwerywbwi\"],[\"gvp\"],[\"jzukdzrfgvdbrunw\"],[\"gvp\",\"kqcrfwerywbwi\"]]"))));
    }

    private List<Integer> res;
    private LinkedList<Integer> curList = new LinkedList<>();
    private int cur;
    private int count;
    private int target;
    private Map<String, Integer> map = new HashMap<>();
    private int[] peoples;
    private List<List<String>> people;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        target = (1 << (req_skills.length)) - 1;
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        this.people = people;
        this.peoples = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            List<String> strings = people.get(i);
            for (String string : strings) {
                mask |= 1 << map.get(string);
            }
            peoples[i] = mask;
        }

        for (int i = 0; i < people.size(); i++) {
            helper(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void helper(int index) {
        cur |= peoples[index];
        curList.addLast(index);
        count++;
        if (res != null && count >= res.size()) {
            count--;
            cur &= ~peoples[index];
            curList.removeLast();
            return;
        }
        if (cur == target && (res == null || count < res.size())) {
            res = new ArrayList<>(curList);
            count--;
            cur &= ~peoples[index];
            curList.removeLast();
            return;
        }
        for (int i = index + 1; i < people.size(); i++) {
            helper(i);
        }
        count--;
        cur &= ~peoples[index];
        curList.removeLast();
    }

}

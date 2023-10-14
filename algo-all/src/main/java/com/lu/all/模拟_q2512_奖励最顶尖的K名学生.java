package com.lu.all;

import org.junit.Test;

import java.util.*;

/**
 * @author sheldon
 * @date 2023-10-14
 */
public class 模拟_q2512_奖励最顶尖的K名学生 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> nega = new HashSet<>(Arrays.asList(negative_feedback));

        int[][] ints = new int[student_id.length][2];

        for (int i = 0; i < report.length; i++) {
            String repo = report[i];
            int score = 0;
            String[] s1 = repo.split(" ");
            for (String s : s1) {
                if (pos.contains(s)) {
                    score += 3;
                }
                if (nega.contains(s)) {
                    score -= 1;
                }
            }
            ints[i] = new int[]{score, student_id[i]};
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int i = ints.length - 1; i > ints.length - 1 - k; i--) {
            res.add(ints[i][1]);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(topStudents(new String[]{"yewmhbgnq","vqhhuaejqw"}, new String[]{"zjeyq","oyuetqe","ks","vuvannpwa","qfd","xv","aauvtxrdt","gml","eaky","mwip"}, new String[]{"lqiuderzod mwip vqhhuaejqw xrn aqjzkqjsi riuood yewmhbgnq xv nmcvqm onhkkmy","uccz yewmhbgnq rcxdaqicbe vqhhuaejqw yewmhbgnq e vqhhuaejqw b yewmhbgnq vqhhuaejqw","eaky yewmhbgnq eaky dwdzl yewmhbgnq yewmhbgnq ntqpnqtmnb qfd ks gvumi","ecutvv vqhhuaejqw vqhhuaejqw inu vqhhuaejqw vqhhuaejqw uu eodzum zjeyq fxebx","vqhhuaejqw m vuvannpwa mwip atvjp vqhhuaejqw eaky yewmhbgnq vqhhuaejqw yewmhbgnq"}, new int[]{581094748,245764367,905556075,127263030,415068015}, 4));
    }

}

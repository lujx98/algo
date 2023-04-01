package com.lu.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author sheldon
 * @date 2023-01-16
 */
public class 模拟_双指针_q1813 {

    @Test
    public void test() {
        System.out.println(areSentencesSimilar("Ogn WtWj HneS", "Ogn WtWj HneS"));
        System.out.println(areSentencesSimilar("of", "A lot of words"));
    }

    public boolean test(String sentence1, String sentence2){
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int i = 0, j = 0;
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        while (j < words1.length - i && j < words2.length - i && words1[words1.length - j - 1].equals(words2[words2.length - j - 1])) {
            j++;
        }
        return i + j == Math.min(words1.length, words2.length);
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        LinkedList<String> target;
        String[] pad;
        if (sentence1.length() > sentence2.length()) {
            target = Arrays.stream(sentence1.split(" ")).collect(Collectors.toCollection(LinkedList::new));
            pad = sentence2.split(" ");
        } else {
            target = Arrays.stream(sentence2.split(" ")).collect(Collectors.toCollection(LinkedList::new));
            pad = sentence1.split(" ");
        }
        int count = 0;
        for (int i = pad.length - 1; i >= 0; i--) {
            String anObject = target.peekLast();
            if (anObject==null){
                return true;
            }
            if (pad[i].equals(target.peekLast())){
                count++;
                target.pollLast();
            }else {
                break;
            }
        }
        for (String s : pad) {
            String anObject = target.peekFirst();
            if (anObject==null){
                return true;
            }
            if (s.equals(anObject)){
                count++;
                target.pollFirst();
            }else {
                break;
            }
        }
        return count >= pad.length;
    }

}

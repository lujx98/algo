package com.lu.algo.string;

/**
 * @author sheldon
 * @date 2022-03-16
 */
public class q58 {
    public static void main(String[] args) {
        lengthOfLastWord("a");
    }

    public static int lengthOfLastWord(String s) {

        int length = 0;
        char[] chars = s.trim().toCharArray();
        char a = ' ';
        for (int i = chars.length - 1; i >= 0; i--) {
            if (a==chars[i]) {
                break;
            }
            length+=1;
        }
        return length;
    }

    public int lengthOfLastWordof(String s) {
        //todo:这么做有可能会超出int类型的大小限制导致无限循环
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        //跳过末尾空格
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

}

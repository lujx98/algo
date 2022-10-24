package com.lu.dmsxl.twopointer;

import org.junit.Test;

import java.util.Objects;

/**
 * @author sheldon
 * @date 2022-10-24
 */
public class Two_qO05_1_ReplaceSpace {

    @Test
    public void test(){
        System.out.println(replaceSpace("We are happy."));
        System.out.println(replaceSpace("     "));
    }

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (Objects.equals(s.charAt(i), ' ')) {
                stringBuilder.append("  ");
            }
        }
        int left = s.length() - 1, right = left + stringBuilder.length();
        s+=stringBuilder.toString();
        char[] chars = s.toCharArray();
        for (int i = left; i >= 0; i--) {
            if (Objects.equals(chars[i],' ')){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right--] = '%';
            }else {
                chars[right--] = chars[i];
            }
        }
        return new String(chars);
    }

    public String replaceSpace1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                stringBuilder.append("  ");
            }
        }
        if (stringBuilder.length()==0) {
            return s;
        }
        int firstPointer = s.length()-1;
        s += stringBuilder.toString();
        int secondPointer = s.length()-1;
        char[] chars = s.toCharArray();
        while (firstPointer>=0){
            if (chars[firstPointer]==' '){
                chars[secondPointer--]='0';
                chars[secondPointer--]='2';
                chars[secondPointer]='%';
            }else {
                chars[secondPointer]=chars[firstPointer];
            }
            firstPointer--;
            secondPointer--;
        }
        return new String(chars);
    }

}

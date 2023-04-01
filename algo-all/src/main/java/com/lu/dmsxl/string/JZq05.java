package com.lu.dmsxl.string;

import java.util.ArrayList;

/**
 * @author sheldon
 * @date 2022-03-31
 */
public class JZq05 {
    public static void main(String[] args) {
        replaceSpace1("     ");
    }

    public static String replaceSpace(String s) {
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
        ArrayList<Object> objects = new ArrayList<>();
        int firstPointer = s.length()-1;
        s += stringBuilder.toString();
        int secondPointer = s.length()-1;
        char[] chars = s.toCharArray();
        while (firstPointer>=0){
            if (chars[firstPointer]==' '){
                chars[secondPointer--]='0';
                chars[secondPointer--]='2';
                chars[secondPointer--]='%';
            }else {
                chars[secondPointer--]=chars[firstPointer];
            }
            firstPointer--;
        }
        return new String(chars);
    }

    public static String replaceSpace1(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量2倍
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}

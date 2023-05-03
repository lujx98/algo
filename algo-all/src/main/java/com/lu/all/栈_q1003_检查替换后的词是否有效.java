package com.lu.all;

import org.junit.Test;

/**
 * @author sheldon
 * @date 2023-05-03
 */
public class 栈_q1003_检查替换后的词是否有效 {

    @Test
    public void test(){
        System.out.println(isValid("abcaabcababcc"));
    }

    public boolean isValid(String s) {
        while (s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return s.length() == 0;
    }

}

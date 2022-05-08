package com.lu.dmsxl.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author sheldon
 * @date 2022-05-05
 */
public class q17LetterCombinations {

    private List<String> result = new ArrayList<>();
    private StringBuilder strB = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() == 0) {
            return result;
        }
        backTracking(digits, numString, 0);
        return result;
    }

    private void backTracking(String digits, String[] numString, int digitsIndex) {
//        if (strB.length() == digits.length()) {
//            result.add(strB.toString());
//            return;
//        }
//
//        String str = numString[digits.charAt(digitsIndex) - '0'];
//        for (int i = 0; i < str.toCharArray().length; i++) {
//            strB.append(str.charAt(i));
//            backTracking(digits, numString, digitsIndex + 1);
//            strB.deleteCharAt(strB.length() - 1);
//        }

        if (strB.length() == digits.length()) {
            result.add(strB.toString());
            return;
        }
        String s = numString[digits.charAt(digitsIndex)];
        for (int i = 0; i < s.length(); i++) {
            strB.append(s.charAt(i));
            backTracking(digits,numString,digitsIndex+1);
            strB.deleteCharAt(digitsIndex);
        }

    }

}

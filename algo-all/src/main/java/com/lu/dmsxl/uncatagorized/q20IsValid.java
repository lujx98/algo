package com.lu.dmsxl.uncatagorized;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

/**
 * @author sheldon
 * @date 2022-09-16
 */
public class q20IsValid {

    @Test
    public void test(){
        System.out.println(isValid("{[]}"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> objects = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            Character peek = objects.peekLast();
            if ((Objects.equals(aChar,')')&&(Objects.equals(peek,'(')))||
                    (Objects.equals(aChar,']')&&(Objects.equals(peek,'[')))||
                    (Objects.equals(aChar,'}')&&(Objects.equals(peek,'{')))){
                objects.pollLast();
            }else {
                objects.add(aChar);
            }
        }
        return objects.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            //如果是左括号则直接入栈
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                //如果是右括号，并且此时栈不为空
                if (!stack.isEmpty()) {
                    if (ch == ')') {
                        if (stack.pop() != '(')
                            return false;
                    } else if (ch == '}') {
                        if (stack.pop() != '{')
                            return false;
                    } else {
                        if (stack.pop() != '[')
                            return false;
                    }
                }
                else{ //此时栈为空，但却来了个右括号，也直接返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}

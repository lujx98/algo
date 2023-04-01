package com.lu.daily;

import org.junit.Test;

import java.util.Objects;

/**
 *  请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 *  给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *  示例 1：
 *
 *  输入：command = "G()(al)"
 *  输出："Goal"
 *  解释：Goal 解析器解释命令的步骤如下所示：
 *  G -> G
 *  () -> o
 *  (al) -> al
 *  最后连接得到的结果是 "Goal"
 *  示例 2：
 *
 *  输入：command = "G()()()()(al)"
 *  输出："Gooooal"
 *  示例 3：
 *
 *  输入：command = "(al)G(al)()()G"
 *  输出："alGalooG"
 *
 * @author sheldon
 * @date 2022-11-06
 */
public class rev_q1678 {

    private static final String s1 = "()";
    private static final String s2 = "(al)";

    @Test
    public void test() {
        System.out.println(interpret("G()(al)"));
    }

    public String interpret(String command) {
        StringBuilder stack = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (char c : command.toCharArray()) {
            if (Objects.equals(c, ')')) {
                stack.append(')');
                if (Objects.equals(s1, stack.toString())) {
                    result.append('o');
                } else if (Objects.equals(s2, stack.toString())) {
                    result.append("al");
                }
                stack.delete(0, stack.length());
            } else if (Objects.equals(c, 'G')) {
                result.append('G');
            } else {
                stack.append(c);
            }
        }
        return result.toString();
    }

    public String best(String command) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < command.length()){
            char c = command.charAt(i);
            if(c == 'G'){
                sb.append('G');
                i++;
                continue;
            }

            char next = command.charAt(i + 1);
            if(next == ')'){
                sb.append('o');
                i += 2;
            }else{
                sb.append('a').append('l');
                i += 4;
            }
        }
        return sb.toString();
    }

}

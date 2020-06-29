package leetcode;

import java.util.LinkedList;
import java.util.List;

/*

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

 */
public class q44_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generate(new char[2 * n], 0, res);
        return res;
    }

    public void generate(char[] chars, int pos, List<String> result) {
        if (pos == chars.length) {
            if (vaild(chars)) {
                result.add(new String(chars));
            }
        } else {
            chars[pos] = '(';
            generate(chars, pos + 1, result);
            chars[pos] = ')';
            generate(chars, pos + 1, result);
        }
    }

    public boolean vaild(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;

    }
}

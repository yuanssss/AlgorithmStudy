package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

 */
public class q29_isValid {
    public static void main(String[] args) {
        String s = "(]";
        q29_isValid q = new q29_isValid();
        System.out.println(q.isValid(s));
    }

    //使用HashMap作为字典，同时使用栈。
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> hm = new HashMap<>();
        Stack<Character>stack=new Stack<>();
        stack.push('?');
        hm.put('[', ']');
        hm.put('{', '}');
        hm.put('(', ')');
        hm.put('?','?');
//        hm.put(']', '[');
//        hm.put('}', '{');
//        hm.put(')', '(');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(hm.containsKey(chars[i]))
            {
                stack.push(chars[i]);
            }
            else if(chars[i]==hm.get(stack.peek()))
            {
                stack.pop();
            }
        }
        stack.pop();
        return stack.isEmpty();
    }
}

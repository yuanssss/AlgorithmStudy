package leetcode;

import java.util.*;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class q41_letterCombinations {
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        iterStr(digits, "", 0, hm);
        return list;
    }

    public void iterStr(String digits, String letter, int index, HashMap<Character, String> hm) {
        if (index == digits.length()) {
            list.add(letter);
            return;
        }
        char c = digits.charAt(index);
        char[] chars = hm.get(c).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            iterStr(digits, letter + chars[i], index + 1, hm);
        }
    }

    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        List<String> lists = new ArrayList<>();
        lists.add("");
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String str = hm.get(c);
            for (int j = 0; j < lists.size(); j++) {
                String tem = lists.remove(0);
                for (int k = 0; k < str.length(); k++) {
                    lists.add(tem + str.charAt(i));
                }
            }
        }
        return lists;
    }
}

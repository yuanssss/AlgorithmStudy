package leetcode;


import java.util.Arrays;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

输入: "cbbd"
输出: "bb"
 */
public class q39_longestPalindrome {

    public static void main(String[] args) {
        q39_longestPalindrome q = new q39_longestPalindrome();
        String s = q.longestPalindrome2("cbbd");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        int maxlen = 1;
        int begin = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (j - i + 1 > maxlen && isHW(chars, i, j)) {
                    maxlen = j - i + 1;//截取字符串是左闭右开
                    begin = i;
                }
            }
        }

        return s.substring(begin, maxlen + begin);
    }

    public boolean isHW(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    //DP
    public String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        int maxlen = 1;
        int begin = 0;
        for (int j = 1; j < chars.length - 1; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j-i< 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j-i + 1 > maxlen) {
                    begin = i;
                    maxlen = j-i + 1;
                }
            }

        }
        return s.substring(begin, begin + maxlen);
    }
}

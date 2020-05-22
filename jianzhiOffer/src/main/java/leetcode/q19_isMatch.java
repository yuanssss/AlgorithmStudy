package leetcode;

import java.util.regex.Pattern;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class q19_isMatch {
    public static void main(String[] args) {
        q19_isMatch q = new q19_isMatch();
        String s = "mississippi";
        String p = "mis*is*p*.";

        boolean res = q.isMatch(s, p);
        System.out.println(res);
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) f[i][j] = i == 0;
                else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else//没有碰到*
                    {
                        if (j >= 2)//不看
                        {
                            f[i][j] |= f[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }

        }
        return f[n][m];
    }


}

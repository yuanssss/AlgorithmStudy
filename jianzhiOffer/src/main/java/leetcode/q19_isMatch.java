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
        String s = "a";
        String p = "aa";
        boolean res = q.isMatch(s, p);
        System.out.println(3%2);
    }

    public boolean isMatch(String s, String p) {
        boolean res = false;
        char[] arrs = s.toCharArray();
        char[] arrp = p.toCharArray();
        char[]longer;
        char[]shoter;
        if(arrs.length<arrp.length)
        {
            shoter=arrs;
            longer=arrp;
        }
        else
        {
            shoter=arrp;
            longer=arrs;
        }
        int count = 0;
        for (int i = 0; i < longer.length; i++) {

            if (i <= shoter.length) {
                for (int j = i; j < shoter.length; j++) {
                    if (longer[i] == shoter[j] || longer[i] == '.' || shoter[j] == '.') {
                        res = true;
                    } else if (longer[i] == '*' && longer[i - 1] == shoter[j]) {
                        res = true;
                    } else if (shoter[j] == '*' && shoter[j - 1] == longer[i]) {
                        res = true;
                    }
                }
            } else {
                if (res==true&&longer[i] == '*') {
                    count++;
                }
            }
        }
        int m=longer.length-shoter.length;
        if(m%2!=0)
        {
            res=false;
        }
        if(res==true&&count==m/2)
        {
            res=true;
        }
        return res;
    }

}

package MeiTuan;
/**
 * 链接：https://www.nowcoder.com/questionTerminal/2e2510b2e41e4d3b922416e51afc077b
 * 来源：牛客网
 *
 * 给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。
 * 模式串中‘？’可以匹配目标串中的任何字符，模式串中的 ’*’可以匹配目标串中的任何长度的串，
 * 模式串的其它字符必须和目标串的字符匹配。例如P=a?b，T=acb，则P 和 T 匹配。
 * 输入
 * a*b
 * ab
 * 输出
 * 1
 *
 * 输入
 * a?b
 * ab
 * 输出
 * 0
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        String t = scanner.nextLine();
        //. 表示 匹配除换行符 /n 之外的任何单字符，*表示零次或多次。所以.*在一起就表示任意字符出现零次或多次。
        if (Pattern.matches(p.replace("*", ".*").replace("?", "."), t)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}



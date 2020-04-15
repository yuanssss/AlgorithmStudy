package MeiTuan;

import java.util.Scanner;
import java.util.Stack;

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        Test1 test1=new Test1();

        String a=  test1.solution(s);
        System.out.println(a);
    }

    public String solution(String[] arr) {

        if (!arr[arr.length - 1].equals("true") && !arr[arr.length - 1].equals("false"))
            return "error";
        String flag = "true";
        for (int i = 0; i < arr.length; i = i + 2) {
            if (!arr[i].equals("true") && !arr[i].equals("false")) {
                return "error";
            }
        }
        for (int i = 1; i < arr.length; i = i + 2) {
            if (!arr[i].equals("and") && !arr[i].equals("or")) {
                return "error";
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("and")) {
                if (arr[i - 1].equals(arr[i + 1])) {
                    flag = "true";
                    arr[i - 1] = "true";
                    arr[i] = "true";
                    arr[i + 1] = "true";
                } else {
                    flag = "false";
                    arr[i - 1] = "false";
                    arr[i] = "false";
                    arr[i + 1] = "false";
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("or")) {
                if (arr[i - 1].equals(arr[i + 1])) {
                    flag = "true";

                } else {
                    flag = "false";

                }
            }
        }
        return flag;

    }
}
package MeiTuan;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
某条街道两侧分别种植了一排树木，并按如下编号：
1 3 5 7 .... 45 47 49 ... 99
2 4 6 8 ... 46 48 50 ... 100
但是有一些树被砍去，希望你能找出一边最长的连续的大树。
输入
第一行一个整数N
第二行N个整数表示被砍去树的编号
输出
M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）
样例输入
5
9 15 27 35 6
样例输出
8 47
 */
public class Tree {
    public static void main(String[] args) {
      Scanner cin=new Scanner(System.in);
      int nums=cin.nextInt();
      int[]ct=new int[nums];

    }
    public int[] cutTree(int nums, int[] ct) {
        List<Integer> ji = new LinkedList<>();//存放被砍掉的奇数的索引
        List<Integer> o = new LinkedList<>();//存放被砍掉的偶数的索引
        int[] tree1 = new int[50];//奇数
        int[] tree2 = new int[50];//偶数
        int msg1 = 0;
        int msg2 = 0;
        //生成奇数和偶数的数组
        for (int i = 1; i <= 99; i = i + 2) {
            tree1[msg1] = i;
            msg1++;
        }
        for (int i = 2; i <= 100; i = i + 2) {
            tree2[msg2] = i;
            msg2++;
        }
        //遍历被砍掉的树的数组
        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < 50; j++) {
                //判断奇偶
                if (ct[i] % 2 == 0) {
                    if (ct[i] == tree2[j]) {
                        o.add(j);
                        break;
                    }
                } else {
                    if (ct[i] == tree1[j]) {
                        ji.add(j);
                        break;
                    }
                }
            }
        }
        //通过被砍掉的索引与25相比较来判断剩余最长的连续的树的数量
        int jiMax=Math.abs(ji.get(0)-25);
        int index1=ji.get(0);//索引
        int oMax=Math.abs(o.get(0)-25);
        int index2=o.get(0);
        for(int i=1;i<ji.size();i++) {
            if(Math.abs(ji.get(i)-25)>jiMax)
            {
                jiMax=Math.abs(ji.get(i)-25);
                index1=ji.get(i);
            }
        }
        for(int i=1;i<o.size();i++) {
            if(Math.abs(o.get(i)-25)>oMax)
            {
                oMax=Math.abs(o.get(i)-25);
                index2=o.get(i);
            }
        }
        int[]out=new int[2];
        //索引与25差值的绝对值越大说明剩下连续的树木数量越多
        if(jiMax<oMax)
        {
            if(index2>25)
            {
                out[0]=tree2[0];
                out[1]=index2-1;
            }
            else {
                out[0]=tree2[index2+1];
                out[1]=50-index2-1;
            }

        }
        else
        {
           if(index1>25)
           {
               out[0]=tree1[0];
               out[1]=index1-1;
           }
           else
           {
               out[0]=tree1[index1+1];
               out[1]=50-index1-1;
           }
        }
        return out;

    }


}


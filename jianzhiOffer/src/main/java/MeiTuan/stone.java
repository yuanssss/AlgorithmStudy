package MeiTuan;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，
且不存在两个石头有相同的半径。为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
问最少需要操作多少次才能将这n个石头的半径变成升序？

5
4 1 2 5 3
 */
public class stone {
    int count = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int nums = cin.nextInt();
        int[] arrays = new int[nums];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = cin.nextInt();
//            System.out.println(arrays[i]);
        }
        stone s = new stone();

        System.out.println(s.stoneSlove(arrays, 1, arrays.length));
    }

    //思路：对数组进行排序，将最小的放到最左，将最大的放到最右，然后移动start和end指针对中间数组进行递归
    public int stoneSlove(int[] arrays, int start, int end) {
        int[] newArr = new int[arrays.length];
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        //递归终止条件
        if (start >= end) {
            return count;
        }
        for (int i = start; i < end; i++) {
            //不是递增顺序
            if (arrays[i] < arrays[i - 1]) {

                if(arrays[i]<=arrays[0])
                {
                    newArr[0] = arrays[i];
                    min = i;

                }
                if(arrays[i-1]>=arrays[arrays.length-1])
                {
                    newArr[arrays.length - 1] = arrays[i - 1];
                    max = i - 1;
                }

                break;
            }
        }
        int k = 1;
        if (newArr[0]<newArr[arrays.length-1]) {
            for (int i = 0; i < end; i++) {
                if (i != min && i != max) {
                    newArr[k] = arrays[i];
                    k++;
                }
            }
            count++;
            stoneSlove(newArr, start + 1, end - 1);
        }

        return count;
    }
}

package leetcode;

import java.util.*;

/*
给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。

返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。


输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
输出: [1, 3]

输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
输出: []
 */
public class q25_findSwapValues {
    public static void main(String[] args) {
        int[] array1 = {4, 1, 2, 1, 1, 2};
        int[] array2 = {3, 6, 3, 3};
        q25_findSwapValues q = new q25_findSwapValues();
    }
    //暴力解法：超时
    public int[] findSwapValues(int[] array1, int[] array2) {
        int temp = 0;
        int[] s = {};
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                int[] nArray1 = Arrays.copyOf(array1, array1.length);
                int[] nArray2 = Arrays.copyOf(array2, array2.length);
                temp = nArray1[i];
                nArray1[i] = nArray2[j];
                nArray2[j] = temp;
                if (isEqual(nArray1, nArray2)) {
                    int[] swapValues = new int[2];
                    swapValues[0] = temp;
                    swapValues[1] = nArray1[i];
                    return swapValues;
                }
            }
        }
        return s;
    }
    public boolean isEqual(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            sum2 += array2[j];
        }
        if (sum1 == sum2)
            return true;
        else
            return false;
    }

    public int[] findSwapValues2(int[] array1, int[] array2) {
        int sum1=0;
        int sum2=0;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<array1.length;i++)
        {
            sum1+=array1[i];
        }
        for(int i=0;i<array2.length;i++)
        {
            sum2+=array2[i];
            set.add(array2[i]);
        }
        if((sum1-sum2)%2!=0)
        {
            return new int[]{};
        }
        else
        {
            int[]sv=new int[2];
            int sub=sum1>sum2?(sum1-sum2)/2:(sum2-sum1)/2;
            for(int i=0;i<array1.length;i++)
            {
                if(set.contains(array1[i]-sub))
                {
                    return new int[]{array1[i],array1[i]-sub};
                }
            }
            return new int[]{};
        }

    }


}

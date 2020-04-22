package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class question13_reOrderArray {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7};
        question13_reOrderArray question13_reOrderArray=new question13_reOrderArray();
        question13_reOrderArray.reOrderArray2(arr);
        System.out.println(arr);
    }
    public void reOrderArray(int [] array) {
        Queue <Integer>queue1=new LinkedList();
        Queue <Integer>queue2=new LinkedList();
        int falg=0;
       for(int i=0;i<array.length;i++)
       {
           if(array[i]%2==0)
           {
               queue2.add(array[i]);

           }
           else
           {
               queue1.add(array[i]);
           }
       }
      while (!queue1.isEmpty())
      {
          array[falg]=queue1.poll();
          falg++;
      }
        while (!queue2.isEmpty())
        {
            array[falg]=queue2.poll();
            falg++;
        }
    }



    public void reOrderArray2(int [] array) {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++) {
            if (array[i] % 2 == 1) {
                int j = i;
                while (j > k) {//j >= k+1
                    int tmp = array[j];
                    array[j] = array[j-1];//把奇数往前移动
                    array[j-1] = tmp;
                    j--;
                }
                k++;//如果是偶数k就不会++
            }
        }
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 */
public class q38_findMedianSortedArrays {
    public static void main(String[] args) {
       int[]num1={1,2,3,4,5};
       int[]num2={3,5,7,8};
       q38_findMedianSortedArrays q=new q38_findMedianSortedArrays();
       double x=q.findMedianSortedArrays(num1,num2);
        System.out.println(9/2);
        System.out.println(x);

    }
    List<Integer>list=new ArrayList<>();
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        cooporate(nums1,nums2);
        int mid=list.size()%2;
        if(mid==1)
        {
            return list.get(list.size()/2);
        }
        else
        {
            int x=list.get(list.size()/2-1);
            int y=list.get(list.size()/2);
            return (double)(x+y)/2;
        }
    }


    public List<Integer> cooporate(int[]nums1,int[]nums2)
    {
       int i=0;int j=0;
       while (i<nums1.length&&j<nums2.length)
       {
           if(nums1[i]<nums2[j])
           {
               list.add(nums1[i++]);
           }
           else
           {
               list.add(nums2[j++]);
           }
       }
       while (i<nums1.length)
       {
           list.add(nums1[i++]);
       }
       while (j<nums2.length)
       {
           list.add(nums2[j++]);
       }
       return list;
    }
}

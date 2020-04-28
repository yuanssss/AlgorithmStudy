package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class q15_MaxSubArray {
    public static void main(String[] args) {
        q15_MaxSubArray q = new q15_MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int a = q.maxSubArray(nums);
        System.out.println(a);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (max < sum) {
                    max = sum;
                } else {
                    break;
                }
            }
            max=Math.max(max,nums[i]);
        }
        return max;
    }

//dp:看前面的对当前增大有没有帮助
        public int maxSubArray1(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}

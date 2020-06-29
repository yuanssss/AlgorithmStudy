package leetcode;

import java.util.*;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

输入: nums = [1], k = 1
输出: [1]
 */
public class q32_topKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 2;
        topKFrequent(nums, k);

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] topK = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], count);
            }
        }
        Collection<Integer> c = map.values();

        int index = 0;
        while (k > 0) {
            int max = Collections.max(c);
            for (Integer m : map.keySet()) {
                if (map.get(m).equals(max)) {
                    topK[index] = m;
                    break;
                }
            }
            c.remove(max);
            index++;
            k--;
        }
        return topK;
    }
}

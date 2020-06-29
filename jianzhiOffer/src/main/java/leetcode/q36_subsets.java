package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class q36_subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>lists=new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i=0;i<nums.length;i++)
        {
            int size=lists.size();
            for(int j=0;j<size;j++)
            {
                List<Integer>subset=new ArrayList<>(lists.get(j));
                subset.add(nums[i]);
                lists.add(subset);
            }

        }
        return lists;
    }
}

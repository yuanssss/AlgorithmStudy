package leetcode;

import java.util.*;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */
public class q40_threeSum {
    public static void main(String[] args) {
        q40_threeSum q = new q40_threeSum();
        int[] nums = {0, 0, 0};
        List<List<Integer>> list = q.threeSum(nums);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; second++) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; ++first) {
            //这样能保证第一个数也能被遍历
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; ++second) {
                if (second > first + 1 && nums[second] == nums[second + 1]) {
                    continue;
                }
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }

                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    lists.add(l);
                }
            }
        }

        return lists;
    }
}

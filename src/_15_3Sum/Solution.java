package _15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * introductions:Given an array nums of n integers,
 * are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * created by Heylink on 2018/5/3 10:07
 * 时间复杂度为O(N^2*logN)
 */
public class Solution {

    public static void main(String[] args) {
        //第一次报错 预期 [[-1,-1,2],[-1,0,1]] 得到[[-1,0,1]]
        //原因：j筛选重复条件出错
        //int[] input = new int[]{-1,0,1,2,-1,-4};
        //第二次报错 少了输出 原因 二分查找写错了
        int[] input = new int[]{3,0,-2,-1,1,2};

        Solution solution = new Solution();

        List<List<Integer>> res = solution.threeSum(input);
        System.out.println("");
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //合法性判断
        if (nums == null || nums.length == 0) {
            return res;
        }
        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //排除重复元素
            if (i == 0 || (nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    //排除重复元素
                    if (j == i + 1 || ((j > i + 1)&&(nums[j] != nums[j - 1]))) {
                        int target = findTarget(nums, j + 1, nums.length - 1, 0 - nums[i] - nums[j]);
                        if (target < 0) {
                            continue;
                        }
                        res.add(Arrays.asList(nums[i], nums[j], nums[target]));
                    }
                }
            }
        }
        return res;
    }

    private int findTarget(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            return -1;
        }
        int index = (lo + hi) / 2;
        if (nums[index] == target) {
            return index;
        }else if (nums[index] < target) {
            return findTarget(nums, index + 1, hi, target);
        }else {
            //条件写错
            return findTarget(nums, lo, index - 1, target);
        }
    }

}

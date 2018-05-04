package _16_3Sum_Closest;

import java.util.Arrays;

/*
 * introductions:给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * created by Heylink on 2018/5/3 11:45
 * 结果：24ms,战胜58%的JAVA提交
 */
public class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{-1,2,1,-4};
        //int[] input = new int[]{-5,-4,-3,-2,3};
        //int[] input = new int[]{-1,0,1,1,55};
        Solution solution = new Solution();

        solution.threeSumClosest(input, 1);
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        //不加这句出错，Math.abs(tempSum - target) < Math.abs(sum - target)
        int sum = target > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //取第一个数
        for (int i = 0; i < nums.length - 2; i++) {
            //避免第一个元素重复
            if (i == 0 || (nums[i] != nums[i - 1])) {
                //取出第二个元素
                for (int j = i + 1; j < nums.length - 1; j++) {
                    //避免第二个元素重复
                    if (j == i + 1 || (j > i + 1) && (nums[j] != nums[j - 1])) {
                        //取出第三个元素
                        int index = findTarget(nums, j + 1, nums.length - 1, target - nums[i] - nums[j]);
                        //计算和
                        int tempSum = nums[i] + nums[j] + nums[index];
                        //找到直接返回
                        if (tempSum == target) {
                            return tempSum;
                        }else if (Math.abs(tempSum - target) < Math.abs(sum - target)) {
                            //相近则更新
                            sum = tempSum;
                        }else {
                            continue;
                        }
                    }
                }
            }
        }
        return sum;
    }

    private int findTarget(int[] nums, int lo, int hi, int target) {
        //如果只有一个元素可选，那就直接返回该元素
        if(lo == hi) {
            return lo;
        }

        int middle = 0;
        while (lo < hi) {
            middle = (lo + hi) / 2;
            if (Math.abs(target - nums[middle]) > Math.abs(target - nums[middle + 1])) {
                lo = middle + 1;
            }else{
                hi = middle - 1;
            }
        }

        return Math.abs(target - nums[middle]) > Math.abs(target - nums[middle + 1]) ? (middle + 1) : middle;
    }
}

package _215_findKthLargest;

import java.util.Arrays;

/*
 * introductions:使用库函数
 * created by Heylink on 2018/5/30 15:31
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

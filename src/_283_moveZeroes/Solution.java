package _283_moveZeroes;

/*
 * introductions:战胜100% JAVA提交
 * created by Heylink on 2018/5/29 10:31
 */
public class Solution {
    //时间复杂度O(n)
    //空间复杂度O(1)
    public void moveZeroes(int[] nums) {
        int k = 0; //nums中，[0...k)的元素均为非0元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

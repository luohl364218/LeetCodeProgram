package _26_removeDuplicates;

/*
 * introductions:
 * created by Heylink on 2018/5/29 11:08
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        //if(nums.length <= 2) return nums.length;
        int id = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1])
                nums[id++] = nums[i];
        }
        return id;
    }
}

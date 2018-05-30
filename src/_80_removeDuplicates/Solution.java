package _80_removeDuplicates;

/*
 * introductions:给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

推广：如果元素最多出现N次，则只需要将下面代码中的2改为N即可
 * created by Heylink on 2018/5/29 22:13
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int k = 1; //[0...k)中元素是有序且重复次数小于等于2的
        int count = 1; //计数器,默认置为1，因为元素始终有一个，不可能没有

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                count = 1;
                nums[k++] = nums[i];
            }else if(nums[i] == nums[i - 1]) {
                if(count < 2) {
                    nums[k++] = nums[i];
                    count++;
                }
            }
        }
        return k;
    }
}

package _283_moveZeroes;

/*
 * introductions:战胜36.72% JAVA提交
 * created by Heylink on 2018/5/29 10:32
 */
public class BetterSolution {
    //时间复杂度O(n)
    //空间复杂度O(1)
    public void moveZeroes(int[] nums) {
        int k = 0; //nums中，[0...k)的元素均为非0元素
        //同时[k...i]都为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    //交换两个元素
                    int temp = nums[k];
                    nums[k++] = nums[i];
                    nums[i] = temp;
                }else {
                    //避免0元素偏多的情况下自己与自己交换的情况
                    k++;
                }
            }
        }
    }
}

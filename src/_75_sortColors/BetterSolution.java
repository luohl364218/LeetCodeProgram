package _75_sortColors;

/*
 * introductions:
 * created by Heylink on 2018/5/30 15:08
 */
public class BetterSolution {

    /**
     * 三向快排
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 只遍历数组一遍
     * @author heylinlook
     * @date 2018/5/30 15:19
     * @param
     * @return
     */
    public void sortColors(int[] nums) {
        int zero = -1;  //nums[0...zero] == 0   初始时无效
        int two = nums.length;        //nums[two...n-1] == 2

        for (int i = 0; i < two; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2) {
                two--;
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            }else {
                // nums[i] == 0
                assert nums[i] == 0;
                zero++;
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

}

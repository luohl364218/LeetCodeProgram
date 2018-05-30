package _75_sortColors;

/*
 * introductions:给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * created by Heylink on 2018/5/30 14:51
 */
public class Solution {

    /**
     * 计数排序
     * 时间复杂度：O(n)
     * 空间复杂度：O(k), O(1)  k为元素的取值范围
     * @author heylinlook
     * @date 2018/5/30 14:59
     * @param
     * @return
     */
    public void sortColors(int[] nums) {
        int[] count = new int[3];  //存放0,1，2三个元素的频率
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] >= 0 && nums[i] <= 2;
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

}

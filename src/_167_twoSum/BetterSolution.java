package _167_twoSum;

/*
 * 时间复杂度O（n）
 * 空间复杂度O（1）
 * introductions:数组+对撞指针类型题目
 * created by Heylink on 2018/6/1 17:15
 */
public class BetterSolution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }else if (numbers[left] + numbers[right] > target) {
                right--;
            }else
                left++;
        }
        return null;
    }
}

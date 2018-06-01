package _11_maxArea;

/*
 * introductions:数组+对撞指针类型题目  盛最多水的容器
 * created by Heylink on 2018/6/1 21:15
 */
public class Solution {
    //思路：从两边向中间移动，每次移动比较矮的那一边，因为如果移动较高的一边，面积只会变小（底*高，底减一，高肯定不超过原来的高）
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int result = 0;
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, area);

            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }

        }
        return result;

    }

}

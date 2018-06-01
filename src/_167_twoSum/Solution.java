package _167_twoSum;

/*
 * 时间复杂度：O(nlogn)
 * introductions:二分查找
 * created by Heylink on 2018/6/1 17:09
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        if(numbers == null || numbers.length == 0) return result;

        for(int i = 0; i < numbers.length; i++) {
            int index = biSearch(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if(index > 0) {
                result[0] = i + 1;
                result[1] = index;
                break;
            }
        }
        return result;
    }

    private int biSearch(int[] array, int a, int lo, int hi) {
        //在[lo...hi]闭区间的范围里查找target
        int mid;
        while(lo <= hi){ //为什么是lo<=hi，不是lo<hi呢？ 因为当lo == hi时，区间[lo...hi]依然是有效的
            //mid=(lo+hi)/2; //这句话有问题，lo+hi会有整型溢出风险
            mid = lo + (hi - lo)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

}

package _26_removeDuplicates;

/*
 * introductions:
 * created by Heylink on 2018/5/29 11:51
 */
public class SimilarSolution {

    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;

        int k = 0; //[0...k]都是有序且不重复
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]) {
                if (i != k) {
                    nums[++k] = nums[i+1];
                }else {
                    k++;
                }
            }
        }
        return k + 1;
    }
}

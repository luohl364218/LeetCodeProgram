package _215_findKthLargest;

/*
 * introductions:做一个大顶堆，下标0 存储元素
 * created by Heylink on 2018/6/1 15:20
 */
public class MaxHeapSolution {

    public static void main(String[] args) {
        MaxHeapSolution solution = new MaxHeapSolution();
        int[] example = new int[]{3,2,3,1,2,4,5,5,6};
        int k = solution.findKthLargest(example, 4);
        System.out.println(k);
    }

    public int findKthLargest(int[] nums, int k) {
        //构建大顶堆
        for (int i = nums.length/2 - 1; i >=0; i--) {
            sink(nums, i, nums.length);
        }
        //取第K-1大的交换完
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, nums.length - 1 - i);
            sink(nums, 0, nums.length - 1 - i);
        }
        //当前为第K大的
        return nums[0];
    }

    //小的元素下沉
    private void sink(int[] nums, int index, int length) {
        int cmpId = 2 * index + 1;
        if (cmpId >= length)
            return;
        //找到两个子节点中比较大的元素
        if ((cmpId < (length - 1)) && nums[cmpId] < nums[cmpId + 1])
            cmpId++;
        //如果当前节点大于较大子节点，则说明不需要交换，返回
        if (nums[index] > nums[cmpId])
            return;
        //替换
        swap(nums, index, cmpId);
        //递归
        sink(nums, cmpId, length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

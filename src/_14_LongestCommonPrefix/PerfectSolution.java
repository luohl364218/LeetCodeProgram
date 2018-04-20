package _14_LongestCommonPrefix;

/**
 * 这个解决思路非常好，巧妙的利用了第一个元素，然后用尾部移除元素来进行不断的匹配
 * @author heylinlook
 * @date 2018/4/20 9:46
 * @param
 * @return
 */
public class PerfectSolution {

    public static void main(String[] args) {
        //输入多个元素的情况
        String[] strs = {"flower","flow","flight"};
        //输入只有一个元素的情况
        //String[] strs = {"    "};
        PerfectSolution solution = new PerfectSolution();
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }
}

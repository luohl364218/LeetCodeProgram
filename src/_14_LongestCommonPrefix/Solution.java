package _14_LongestCommonPrefix;

/**
 * 易错点归纳：
 * 1.控制变量要注意，第一次提交失败就是因为指向String元素中单个字符的下标index变量忘了自增
 * 2.注意对输入参数的判断，第二次提交失败是因为忘了String[]数组中会出现的元素个数为1的情况
 * @author heylinlook
 * @date 2018/4/20 9:35
 * @param
 * @return
 */
public class Solution {

    public static void main(String[] args) {
        //输入多个元素的情况
        //String[] strs = {"flower","flow","flight"};
        //输入只有一个元素的情况
        String[] strs = {"    "};
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0)
            return "";
        //针对输入只有一个元素的情况
        if (strs.length == 1)
            return strs[0];

        int length = 0;  //最长公共长度
        int index = 0;   //访问每个String元素的下标
        boolean flag = true;  //标记位 false表示停止循环
        while(flag){
            //循环遍历strs的每一个元素（默认 strs.length >= 2）
            for(int i = 0; i < strs.length - 1; i++) {
                //下标合法性检查
                if(strs[i].length() <= index || strs[i + 1].length() <= index){
                    //判断当前位置的String元素是否遍历完，遍历完则退出循环
                    flag = false;
                    break;
                }
                //匹配对应位置字符是否相等
                else if(strs[i].charAt(index) == strs[i + 1].charAt(index)){
                    //如果循环完一次  则length++
                    if(i == strs.length - 2){
                        //第一次忘了把下标index++导致死循环
                        index++;
                        length++;
                    }
                    continue;
                }
                else{
                    flag = false;
                    break;
                }
            }
        }

        if(length == 0)
            return "";
        else
            return strs[0].substring(0, length);
    }

}

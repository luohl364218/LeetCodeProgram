package _125_isPalindrome;

/*
 * introductions:数组+对撞指针类型题目
 * created by Heylink on 2018/6/1 17:36
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        //s = s.toLowerCase();
        while(left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            //如果是字符和数字
            if(isValid(l) && isValid(r)) {
                //如果相等则继续循环
                if(l == r) {
                    left++;
                    right--;
                    continue;
                }else if(isLetter(l) && isLetter(r)){  //不相等，继续判断是否是大小写字母
                    if(l == r + 32 || l == r - 32) {
                        left++;
                        right--;
                        continue;
                    }else {
                        return false;
                    }
                }
                else
                    return false;
            }
            //遇到无效字符，跳过
            if (!isValid(l)) {
                left++;
            }
            //遇到无效字符，跳过
            if (!isValid(r)) {
                right--;
            }
        }
        return true;
    }
    //是否是数字和字符
    private boolean isValid(char c) {
        if(c >= '0' && c <= '9')
            return true;
        else
            return isLetter(c);
    }
    //是否是字符
    private boolean isLetter(char c) {
        if(c >= 'A' && c <= 'Z')
            return true;
        else if(c >= 'a' && c <= 'z')
            return true;
        else return false;
    }


}

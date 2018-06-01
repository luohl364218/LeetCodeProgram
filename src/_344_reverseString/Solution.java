package _344_reverseString;

/*
 * introductions:反转字符串
 * created by Heylink on 2018/6/1 19:16
 */
public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

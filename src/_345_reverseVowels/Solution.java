package _345_reverseVowels;

/*
 * introductions:编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * created by Heylink on 2018/6/1 20:35
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] charList = s.toCharArray();
        int left = 0;
        int right = charList.length - 1;

        while(left < right) {
            if(isVowel(charList[left]) && isVowel(charList[right])) {
                char temp = charList[left];
                charList[left] = charList[right];
                charList[right] = temp;
                left++;
                right--;
                continue;
            }

            if(!isVowel(charList[left]))
                left++;

            if(!isVowel(charList[right])) {
                right--;
            }
        }
        return new String(charList);
    }

    private boolean isVowel(char c) {
        if(c == 'A' || c == 'a' || c == 'e' || c == 'E'
                ||c == 'i'|| c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U')
            return true;
        else
            return false;
    }
}

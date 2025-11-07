import java.util.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String a = s.substring(0, i);
            String b = s.substring(i);
            String sum = b + a;

            if (sum.charAt(0) != '(' && sum.charAt(0) != '{' && sum.charAt(0) != '[') continue;
            char[] charArray = sum.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                if (c == '(' || c == '{' || c == '[') stack.push(c);
                else {
                    if (stack.isEmpty()) break;
                    if (c == ')') {
                        if (stack.pop() != '(') break;
                    } else if (c == '}') {
                        if (stack.pop() != '{') break;
                    } else if (c == ']') {
                        if (stack.pop() != '[') break;
                    } else {
                        break;
                    }
                }

                if (j == charArray.length - 1) {
                    result += stack.isEmpty() ? 1 : 0;
                }
            }
        }
        return result;
    }
}
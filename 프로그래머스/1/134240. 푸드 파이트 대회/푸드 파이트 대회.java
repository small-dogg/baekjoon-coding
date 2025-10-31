import java.util.Stack;

class Solution {
    public String solution(int[] food) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            if (food[i] >= 2) {
                int halfFood = food[i] / 2;
                for (int j = 0; j < halfFood; j++) {
                    sb.append(i);
                    stack.push(i);
                }
            }
        }
        sb.append(0);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
import java.util.*;

class Solution {
    public int solution(int[] order) {
        //1번부터 n번 상자가지 컨테이너벨트에 일렬

        //뽑은 대상이 지금 순서가 아니면 일다 ㄴ대기(보조컨테이너벨트)
        //보조컨테이너벨트 : 앞뒤로 이동가능, 하지만 맨 앞상자만 꺼낼 수 있음(Stack)

        int truck = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }

        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        while (idx < order.length && !queue.isEmpty()) {
            if(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                truck++;
                idx++;
            }else {
                Integer box = queue.poll();
                
                if (box == order[idx]) {
                    truck++;
                    idx++;
                } else {
                    stack.push(box);
                }
            }
        }

        while(idx < order.length && !stack.isEmpty() && stack.peek() == order[idx]){
            stack.pop();
            truck++;
            idx++;
        }
        
        return truck;
    }

}

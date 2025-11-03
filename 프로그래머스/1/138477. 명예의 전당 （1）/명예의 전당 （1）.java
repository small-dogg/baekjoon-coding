import java.util.PriorityQueue;
//우선순위 큐
class Solution {
    public int[] solution(int k, int[] score) {

        int[] result = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            if (queue.isEmpty() || queue.peek() < score[i] || queue.size() < k) {
                queue.add(score[i]);
            }
            if (queue.size() > k) {
                queue.poll();
            }
            result[i] = queue.peek();
        }
        return result;

    }
}
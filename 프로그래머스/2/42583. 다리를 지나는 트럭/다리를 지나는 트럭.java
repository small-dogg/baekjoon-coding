import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //모든 트럭이 다리를 건너려면 최소 몇초?
        //다리는 최대 weight 만큼 무게를 견딜 수 있음

        //매 초만큼 while이 동작
        //각 초마다 트럭을 추가롤 올릴 수있는지 검증
        //길이마다 한번씩 pop
        int sec = 0; // 경과 시간
        int count = 0; // 빠져나온 트럭의 수
        int nowWeight = 0; // 현재 다리의 무게
        int idx = 0;//다음 트럭이 올 위치

        //다리길이만큼 큐 미리 채워두기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        while (count < truck_weights.length) {
            //1초식 증가
            sec++;
            int poll = q.poll();
            if (poll != 0){
                nowWeight -= poll;
                count++;
            }

            if (idx < truck_weights.length && nowWeight + truck_weights[idx] <= weight) {
                nowWeight += truck_weights[idx];
                q.add(truck_weights[idx]);
                idx++;
            } else {
                //다리위에 아무도 안올라갔음
                q.add(0);
            }
        }

        return sec;
    }
}
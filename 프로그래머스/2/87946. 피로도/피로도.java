import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int k, int[][] dungeons) {

        //던전을 도는 순서를 순열로 정의
        //최대 던전 순회 길이 8!
        //각 던전을 피로도를 사용하면서 돌 수 있는길이를 획득
        //max 값 산출

        boolean[] visited = new boolean[dungeons.length];

        int[] locationArr = new int[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            locationArr[i] = i;
        }

        List<List<Integer>> intArr = new ArrayList<>();
        permutation(locationArr, new ArrayList<>(), visited, 0, intArr);

        int max = Integer.MIN_VALUE;

        for (List<Integer> list : intArr) {
            int cnt = 0;
            int score = k;
            for (Integer i : list) {
                if(score >= dungeons[i][0]){
                    cnt ++;
                    score -= dungeons[i][1];
                }
            }
            if(cnt > max) max = cnt;
        }
        return max;
    }

    private void permutation(int[] dungeons, List<Integer> now, boolean[] visited, int depth, List<List<Integer>> intArr) {
        //종료조건 : dungeons.length와 depth가 동일하면(더이상 탐색할 던전이 없으면)
        if(dungeons.length == depth) intArr.add(new ArrayList<>(now));
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                now.add(dungeons[i]);
                permutation(dungeons, now, visited, depth + 1, intArr);
                now.remove(now.size()-1);
                visited[i] = false;
            }
        }
    }
}
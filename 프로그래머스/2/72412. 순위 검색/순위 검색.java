import java.util.*;
import java.util.function.Consumer;

// 풀이수준 : C
// 이해가 안가는 부분은 info로 모든 조건을 획득하는부분.(재귀에 대한 이해가 좀더 필요할듯)
// 나는 클래스로 정의해서 compareTo를 오버라이드할라고햇는데, 물론 비교하기위해 정렬하는것은 중요하지만
// info 배열을 가지고 모든 조건을 나열하여 Map으로 담아야겠다는 생각을 못한 것 같음.
// 가능한 경우의수를 일단 모두 획득하고 query의 조건에 대응되는 key가 있는지 색출하는게 더빨랐을텐데..
public class Solution {

    public int[] solution(String[] info, String[] query) {
        /**
         * 언어 : java python cpp -
         * 직군 : backend frontend -
         * 경력 : junior senior -
         * 소울 푸드 : pizza chicken -
         * 점수 : 1 - 100,000
         * 가능한 조건 4 x 3 x 3 x 3 = 108
         */

        /**
         * 풀이 방법
         * info 원소의 점수와 조건을 분리
         * 각 모든 조건을 기반으로 모든 경우의 수 획득(scoresMap)
         * query 원소에 해당하는 조건을 갖는 대상에서 점수를 가지고 이진 탐색 후, 결과 생성 반환
         */

        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = new int[query.length];
        for (int i = 0; i < answer.length; i++) {
            // scoresMap을 이용하여 query에맞는 지원자 수 세기
            answer[i] = count(query[i], scoresMap);
        }
        
        return answer;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        //scoresMap을 이용하여 query에 맞는 지원자 수 세기
        //"- and - and - and - 150"
        String[] tokens = query.split(" (and )?");
        //score를 제외한 마너지 문자열을 key로 획득
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) return 0;
        //query에 맞는 스코어 정보 획득
        List<Integer> scores = scoresMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        //점수 분리
        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);

            //scoreMap에 추가 - tokens로 만들 수 있는 모든 조건 획득
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        return scoresMap;
    }

    //모든 조건 획득하기(재귀)
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        //종료 조건 : index가 토큰길이일 때
        if (index == tokens.length - 1) {
            // prefix가 만들어진 검색 조건
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    private int binarySearch(int score, List<Integer> scores) {
        //조건을 만족하는 값 중 가장 작은값 [start,end]

        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            //중간 값에 따라 범위 좁히기
            int mid = (start + end) / 2;
            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < score) {
            return scores.size();
        }
        return start;
    }

    /**
     * 직접 풀이 실패
     * private class Target implements Comparable<Target> {
     * private String language;
     * private String job;
     * private String career;
     * private String favorite;
     * private int score;
     * <p>
     * public Target(String language, String job, String career, String favorite, int score) {
     * this.language = language;
     * this.job = job;
     * this.career = career;
     * this.favorite = favorite;
     * this.score = score;
     * }
     *
     * @Override public int compareTo(Target o) {
     * return this.score - o.score;
     * }
     * }
     * <p>
     * <p>
     * public int[] solution(String[] info, String[] query) {
     * //        각 언어 직군 경력 소울 푸드 점수필드를 구성하는 클래스를 정의하고, 인스턴스를 생성
     * <p>
     * //info를 순회하여, Target 클래스 리스트로 변경, 그리고 점수기준으로 정렬
     * //현재 풀이하는 문제는 이진탐색이니깐, 점수를 기준으로 정렬을 하고 이진탐색을 해야할까?
     * List<Target> targetList = Arrays.stream(info)
     * .map(string -> {
     * StringTokenizer st  = new StringTokenizer(string);
     * return new Target(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
     * })
     * .sorted(Target::compareTo)
     * .collect(Collectors.toList());
     * <p>
     * System.out.println("aa");
     * <p>
     * //[score_start, score_end) 로 범위를 정의하고, query_score가 나올때까지 이진탐색을하는데, 단, start만 무조건 갱신하는거야.
     * // start가 query_score가 될때까지 탐색하는거..
     * //그리고 탐색이 완료되면 end-start의 크기를 구하는거지.
     * }
     */
}
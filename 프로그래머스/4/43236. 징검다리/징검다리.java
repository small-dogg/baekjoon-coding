import java.util.*;
//풀이 수준 :C (그래도 잘 이해했음.)
class Solution {
    // | --- distance ---|
    // 바위 몇개 제거
    // 바위 위치 :  2 11 14 17 21

    public int solution(int distance, int[] rocks, int n) {
        // 바위 위치 정렬
        // 시작점 0 과 끝지점 distance를 앞뒤로 추가하여 신규 배열 생성
        // n 크기에 맞게 rocks를 통해 조합 생성
        // 거리를 반환한뒤, 각 원소별 거리 길이 최소값 획득 int
        // int[] 에서 max 획득

//        ---
        // 근데 문제에서 distance가 10억이니깐 이건 이분 탐색을 해야하는건가? 라고 유추.
        // 그러면 거리안에서 이분탐색을 해야되는데 시작점 0부터 끝점 distance를 가지고 이분탐색?
        // 이분탐색할때는 배열의 크기를 기준으로 이분탐색?

        // --- 여기까지 개인 고민

        //0과 distance 추가하여 배열 정의
        Arrays.sort(rocks);

        int[] arr = new int[rocks.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = distance;
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = rocks[i - 1];
        }

        long left = 1;
        long right = distance;

        //중간거리를 만족하는 바위만 유지하고 바위를 제거.하여 n만큼 제거했을때 만족하는 결과를 찾음.
        //만약 제거된 바위수가 n보다 크면 그다음 좀더 범위를 늘려서 중간값을 찾아 다시 계산
        //제거된 바위수가 n과 같으면 임시결과를 정의하고, 범위를 좀더 좁혀서 다시 계산
        long result = left;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (can(arr, mid, n)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) result;

    }

    //돌들을 순회하면서, 돌사이 간격이 mid보다 작으면 돌을 제거하는데
    //제거된 돌이 n을 넘으면 실패
    //안넘으면 성공 -> 범위를 더 좁혀서 처리해보자
    private boolean can(int[] rocks, long mid, int n) {
        int removed = 0;
        long last = 0;
        for (int i = 1; i < rocks.length; i++) {
            if (rocks[i] - last < mid) {
                removed++;
                if(removed>n) return false;
                continue;
            }
            last = rocks[i];
        }
        return true;
    }
}
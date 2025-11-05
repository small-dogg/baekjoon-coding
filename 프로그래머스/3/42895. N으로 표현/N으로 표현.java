import java.util.*;
//풀이수준 : C-
//이해가 잘 가지 않았던 영역은 서로다른 N길이의 Set을 조합해서 만들 수 있는 사칙연산을 수행하는 과정이었는데.
// 그부분을 이해하는데 어려움이 있었음. (가장 큰 바깥 괄호가 Set 한덩어리다 라고 취급할 수 있어야되는데 그게 안됨..)
class Solution {
    public int solution(int N, int number) {
        //N이랑 number가 같으면 바로 반환
        if (N == number) return 1;

        //N의 최대 길이만큼 담을 리스트 정의
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());// 0번은 없으니깐 더미

        for (int i = 1; i <= 8; i++) {
            Set<Integer> current = new HashSet<>();

            // N을 i번 이어붙인 수 사전 정의
            int concat = 0;
            //현재 사용할수 있는 N의 길이(i)만큼 반복하여 N을 붙힘
            for (int k = 0; k < i; k++) {
                //예) i가 1인 경우, N을 한번 붙힐 수 있음
                concat = concat * 10 + N;
            }
            current.add(concat);

            // j + (i-j)로 쪼개서 사칙연산 조합
            // 2) j + (i - j) 로 쪼개서 사칙연산 조합
            for (int j = 1; j < i; j++) {
                Set<Integer> left = dp.get(j);       // N을 j번 사용해서 만든 수들
                Set<Integer> right = dp.get(i - j);  // N을 i-j번 사용해서 만든 수들

                for (int a : left) {
                    for (int b : right) {
                        current.add(a + b);
                        current.add(a - b);
                        current.add(b - a); // a가 음수거나 b가 음수일때 결과가 달라질 수 있음
                        current.add(a * b);
                        if (b != 0) current.add(a / b);
                        if (a != 0) current.add(b / a);
                    }
                }
            }

            //number가 이미 만들어졌으면 종료하고 정답으로 N의 개수인 i를 반환
            if (current.contains(number)) {
                return i;
            }

            dp.add(current);
        }

        //8번 돌면서까지 못만들면 -1
        return -1;
    }
}
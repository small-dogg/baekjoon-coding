import java.util.*;

public class Solution {

    public int[] solution(int[][] users, int[] emoticons) {
        //1차 목표 : 가입자 늘리기
        //2차 목표 : 판매액 최대한 늘리기
        //n명에게 m개를 할인 판매함. 10~40%
        //사용자는 자기 기준대비 높은 비율로 할인시 이모티콘 몯 ㅜ구매함
        //사용자는 이모티콘 구매 비용의 합이 일정 가격 이상이 되면 모두 취소하고 서비스를 가입함.

//        emoticons 길이만큼 할인 율 조합 만들기
        List<List<Integer>> rateList = new ArrayList<>();
        int depth = 0;
        int n = emoticons.length;
        comb(n, depth, new ArrayList<>(), rateList);

        int maxSignIn = 0;
        int totalCost = 0;

        //특정 할일 율로 emoticon을 제공했을때
        for (List<Integer> list : rateList) {
            int signIn = 0;
            int cost = 0;

            for (int[] user : users) {
                int userCost = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (list.get(i) >= user[0]) {
                        userCost += emoticons[i] * (100-list.get(i)) / 100;
                    }
                }
                if(userCost >= user[1]) signIn++;
                else cost += userCost;
            }

            if (maxSignIn < signIn) {
                maxSignIn = signIn;
                totalCost = cost;
            } else if(signIn == maxSignIn && cost > totalCost) totalCost = cost;
        }

        return new int[]{maxSignIn, totalCost};
    }

    private void comb(int n, int depth, List<Integer> nowList, List<List<Integer>> rateList) {
        if (depth == n) {
            rateList.add(new ArrayList<>(nowList));
            return;
        }

        for (int i = 0; i < 4; i++) {
            nowList.add((i + 1) * 10);
            comb(n, depth + 1, nowList, rateList);
            nowList.remove(nowList.size() - 1);
        }
    }

}

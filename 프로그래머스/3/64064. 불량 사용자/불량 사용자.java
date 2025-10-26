import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        //banned_id 에 해당하는 user_id를 추출하고,
        //조합을 구한다.

        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replaceAll("\\*", "."))
                .map(banned -> Arrays.stream(user_id)
                        .filter(user -> user.matches(banned))
                        .toArray(String[]::new)
                ).toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        if( index == bans.length ) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        for (String id : bans[index]) {
            if (banned.contains(id)) continue;
            banned.add(id);
            count(index+1, banned, bans, banSet);
            banned.remove(id);
        }
    }
}
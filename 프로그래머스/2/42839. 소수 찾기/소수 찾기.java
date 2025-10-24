import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private static boolean[] visited;

    
    public int solution(String numbers) {
        //순열을 먼저 만들고,
        //순열의 각 항목들의 소수 여부를 확인하는 문제?

        int result = 0;

        visited = new boolean[numbers.length()];

        char[] charArray = numbers.toCharArray();
        int[] data = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            data[i] = charArray[i] - '0';
        }

        Set<Integer> set = new HashSet<>();
        dfs(data, visited, new ArrayList<>(), set);

        for (int i : set) {
            if (isPrime(i)) result++;
        }

        return result;
    }

    private void dfs(int[] arr, boolean[] visited, List<Integer> current, Set<Integer> result) {
        if (!current.isEmpty()) {
            result.add(print(current));
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(arr[i]);
                dfs(arr, visited, current, result);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }


    private int print(List<Integer> output) {
        StringBuilder sb = new StringBuilder();
        for (int i : output) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }

        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (int i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
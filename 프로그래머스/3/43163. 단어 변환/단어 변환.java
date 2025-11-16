import java.util.*;

class Solution {
    class Node {
        String word;
        int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        //한번에 한개의 알파벳만 변경 가능
        //words에 있는 단어로만 변경 가능

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.offer(new Node(begin, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.word.equals(target)) {
                return now.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (isDiffOnlyOne(word, now.word)) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(new Node(word, now.count+1));
                    }
                }
            }
        }
        return 0;
    }
    
    private boolean isDiffOnlyOne(String a, String b) {
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) count++;
        if (count > 1) return false;
    }
    return count == 1;
    }
}
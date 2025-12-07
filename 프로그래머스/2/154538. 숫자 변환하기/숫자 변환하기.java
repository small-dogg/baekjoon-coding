import java.util.*;

class Solution {

    class Action {
        int now;
        int count;

        public Action(int now, int count) {
            this.now = now;
            this.count = count;
        }
    }

    public int solution(int x, int y, int n) {

        boolean[] visited = new boolean[y + 1];

        Queue<Action> q = new LinkedList<>();
        q.offer(new Action(x, 0));
        visited[x] = true;

        while (!q.isEmpty()) {
            Action poll = q.poll();

            if (poll.now == y) return poll.count;

            int one = poll.now + n;
            if (one <= y && !visited[one]) {
                visited[one] = true;
                q.offer(new Action(one, poll.count + 1));
            }

            int two = poll.now * 2;
            if (two <= y && !visited[two]) {
                visited[two] = true;
                q.offer(new Action(two, poll.count + 1));
            }

            int three = poll.now * 3;
            if (three <= y && !visited[three]) {
                visited[three] = true;
                q.offer(new Action(three, poll.count + 1));
            }
        }

        return -1;
    }

 }
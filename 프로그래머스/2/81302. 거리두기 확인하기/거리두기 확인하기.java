// 풀이수준 : C
class Solution {
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {1, 0, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            //방마다 배치
            for (int j = 0; j < place.length; j++) {
                room[j] = place[j].toCharArray();
            }
            //거리두기 검사
            answer[i] = isDistanced(room) ? 1 : 0;

        }

        return answer;
    }

    private boolean isDistanced(char[][] room) {
        //거리두기 검사
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                //응시자가 아닌 경우 건너뜀
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;

            }
        }

        return true;
    }

    private boolean isDistanced(char[][] room, int x, int y) {
        //room[y][x]가 거리두기를 지키는지 검사
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 가려는 위치가
            if (ny < 0  // 윗벽이거나
                    || ny >= room.length// 아랫벽이거나
                    || nx < 0 // 좌측벽이거나
                    || nx >= room[ny].length//우측 벽이면
            ) continue;

            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    //이동후 인접한 곳에 다른 응시자가 있는지 검사(맨하튼 거리 2이하인지)
                    // 3 -d 를하면 접근된 위치의 반대방향을 정의할 수 있음
                    if (isNextToVolunteer(room, nx, ny, 3 - d)) return false;
                    break;

            }
        }
        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            //이전 위치 스킵
            if (d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];

            //인접 위치에 벽 스킵
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            //맨하튼거리 2에 사람이 있으면 true
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
}
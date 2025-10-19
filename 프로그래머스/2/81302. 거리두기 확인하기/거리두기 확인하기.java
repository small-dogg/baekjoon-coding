class Solution {
    //아래, 위, 왼쪽, 오른쪽
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};
    
    //맨하튼 '2'의 위치에 사람이 하나도 없으면 실패
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if(d == exclude) continue;

            int nx = x + dx[d];
            int ny = y + dy[d];

            //현재의 위치가 벽이면
            if(ny <0 || ny >= room.length || nx < 0|| nx >= room[ny].length) continue;

            if (room[ny][nx]=='P') return true;
        }
        return false;
    }

    //거리두기 검사 시작
    private boolean isDistance(char[][] room, int x, int y) {
        //진행방향 현재 위치 기준으로 아래, 왼쪽, 오른쪽, 위
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            //변환된 위치가 벽이면
            if( ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;

            //벽이 아닌 해당 위치를 검사
            switch (room[ny][nx]){
                case 'P': return false;
                case 'O':
                    //인접한 곳에 다른 응시자가 있는지 검사
                    //단, 기존 진행방향으로 넘어온 대상은 제외하기 위해 '3-d'
                    if(isNextToVolunteer(room, nx, ny, 3-d)) return false;
                    break;
            }

        }
        return true;
    }

    // 전체를 순회하며 사람인지 체크하고 사람인 경우에 대해 처리한다.
    private boolean isDistance(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if(!isDistance(room, x, y)) return false;
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for (int i = 0; i < result.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistance(room)) {
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }
        return result;
    }
}
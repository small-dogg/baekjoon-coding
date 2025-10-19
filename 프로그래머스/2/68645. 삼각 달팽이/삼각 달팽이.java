class Solution {
    public int[] solution(int n) {
        //n*n 2차원 배열 생성
        //입력될 값 v 생성
        int[][] triangle = new int[n][n];
        int v = 1;

        //값 채울 위치 초기화
        int x = 0;
        int y = 0;

        while (true) {
            // 아래로 이동
            while (true) {
                //값 채우기
                triangle[y][x] = v++;
                //아래 마지막 위치에 도달했거나, 아래쪽에 값이있으면 정지
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1;
            }

            //오른쪽으로 갈 수 있는지 검증
            if (x + 1 == n || triangle[y][x + 1] != 0) break;
            x += 1;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }

            //왼쪽 위로 이동할 수 있는지 검증
            if (triangle[y - 1][x - 1] != 0) break;
            x -= 1;
            y -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y - 1][x - 1] != 0) break;
                x -= 1;
                y -= 1;
            }

            //아래로 내려갈 수 있는지 검증
            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y += 1;
        }

        int[] result = new int[v - 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}
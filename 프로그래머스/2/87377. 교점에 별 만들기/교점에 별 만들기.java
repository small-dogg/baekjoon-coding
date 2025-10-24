// 풀이수준 : B-
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                // line[i], line[j]를 이용하여 교점 좌표 구하기 및 정수 좌표 선별
                Point intersection = intersection(
                        line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                if (intersection != null) points.add(intersection);
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        //좌표에 맞는 2차원 배열 선언
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

        //모든 요소에 . 찍기
        char[][] arr = new char[height][width];
        for (char[] chars : arr) {
            Arrays.fill(chars, '.');
        }

        //별찍기
        for (Point point : points) {
            int x = (int) (point.x - minimum.x);
            int y = (int) (maximum.y - point.y);

            arr[y][x] = '*';
        }

        //문자열 배열 변환
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }
    
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
//        a1 + b1 + c1 = 0
//        a2 + b2 + c2 = 0
        //교점 구하여 반환하기
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) return null; // 정수의 경우에만 반환
        return new Point((long) x, (long) y);
    }
    
    private Point getMinimumPoint(List<Point> points) {
        // 가장 작은 좌표 찾기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        // 가장 큰 좌표 찾기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point p : points) {
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }

        return new Point(x, y);
    }
    
    private class Point {
        public final long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
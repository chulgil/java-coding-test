package me.chulgil.cote.basic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 교 점 에   별   만 들 기   -   L e v e l   2
 * URL
 * https://programmers.co.kr/learn/courses/30/lessons/87377
 */
public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] line = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12},
        };

        String[] sol = solution.solution(line);
        for (String s : sol) {
            System.out.println(s);
        }
    }

    static class Solution {

        public String[] solution(int[][] line) {

            String[] answer = {};
            List<Point> points = new ArrayList<>();
            // 1. 모든 직선 쌍에 대해 반복
            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    // line[i] line[j] 를 이용하여 1-A, 1-B 수행
                    Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                            line[j][0], line[j][1], line[j][2]);
                    //  B. 정수 좌표만 저장
                    if (intersection != null) {
                        points.add(intersection);
                    }
                }
            }

            // 2. 좌표의 최대값, 최솟값 구하기
            Point min = getMinPoint(points);
            Point max = getMaxPoint(points);

            // 3. 2차원 배열 크기 결정
            int width = (int) (max.x - min.x) + 1;
            int height = (int) (max.y - min.y) + 1;

            char[][] arr = new char[height][width];
            for (char[] row : arr) {
                Arrays.fill(row, '.');
            }

            // 4. 별표시
            for (Point p : points) {
                // 변환된 2차원 배열 좌표로 접근
                int x = (int) (p.x - min.x);
                int y = (int) (max.y - p.y);
                arr[y][x] = '*';
            }

            // 5. 문자열 배열로 변환후 반환
            String[] result = new String[arr.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = new String(arr[i]);
            }

            return result;
        }

        //  A. 교점 좌표 구하기
        private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {

            // 교점 구해서 반환
            double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
            double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

            // 정수가 아니면 null
            if (x % 1 != 0 || y % 1 != 0) return null;

            return new Point((long) x, (long) y);
        }

        private Point getMinPoint(List<Point> points) {
            long x = Long.MAX_VALUE;
            long y = Long.MAX_VALUE;

            for (Point p : points) {
                if (p.x < x) x = p.x;
                if (p.y < y) y = p.y;
            }
            return new Point(x, y);
        }

        private Point getMaxPoint(List<Point> points) {
            long x = Long.MIN_VALUE;
            long y = Long.MIN_VALUE;

            for (Point p : points) {
                if (p.x > x) x = p.x;
                if (p.y > y) y = p.y;
            }
            return new Point(x, y);
        }
    }

    /**
     * 데이터 값만 나타내기에 불변성으로 final 사용후 생성자 초기화
     * 좌표값이 클수 있어 long으로 해야 오버플로우가 발생하지 않음
     */
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

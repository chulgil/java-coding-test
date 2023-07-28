package me.chulgil.cote.basic3;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 삼각 달팽이   -   L e v e l   2
 * URL
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
public class Main {

    @Test
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] res = solution.solution(6);
        System.out.println(Arrays.toString(res));
        String expected = "[1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11]";
        assertThat(Arrays.toString(res), is(expected));
    }

    static class Solution {

        public static final int[] DX = {0, 1, -1}; // 하, 우, 상좌
        public static final int[] DY = {1, 0, -1}; // 하, 우, 상좌

        private int max = 0;
        private int min = -1;






        public int[] solution(int n) {
            max = n;
            // 0. n x n 배열 선언
            int[][] triangle = new int[max][max];

            int v = 1;
            int x = 0;
            int y = 0;
            int d = 0;

            // 2. 방향에 따라 이동할수 없을때까지 증가수 채우기
            while (true) {

                triangle[y][x] = v++;
                int nx = x + DX[d];
                int ny = y + DY[d];

                // 더이상 이동할수 없을때 방향 전환
                if (isNoMoreMoving(nx, ny, triangle)) {
                    d = (d + 1) % 3;
                    nx = x + DX[d];
                    ny = y + DY[d];
                    if(isNoMoreMoving(nx, ny, triangle)) {
                        break;
                    }
                }
                x = nx;
                y = ny;
            }

            int[] res = new int[v - 1];
            int idx = 0;
            for (int i = 0; i < max; i++) {
                for (int j = 0; j <= i; j++) {
                    res[idx++] = triangle[i][j];
                }
            }
            return res;
        }

        private boolean isNoMoreMoving(int nx, int ny, int[][] triangle) {
            return nx == max || ny == max || nx == min || ny == min || triangle[ny][nx] != 0;
        }
    }
}

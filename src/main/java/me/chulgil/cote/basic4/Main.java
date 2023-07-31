package me.chulgil.cote.basic4;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * 거리두기 확인하기   -   L e v e l   2
 * URL
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Main {

    @Test
    public static void main(String[] args) {

        Solution solution = new Solution();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] res = solution.solution(places);
        System.out.println(Arrays.toString(res));
        String expected = "[1, 0, 1, 1, 1]";
        assertThat(Arrays.toString(res), is(expected));

    }

    static class Solution {

        // 상 좌 우 하
        private final int[] dx = {0, -1, 1, 0};
        private final int[] dy = {-1, 0, 0, 1};

        /**
         * 1. 대기실의 모든 응시자 위치에 반복
         * A. 상하좌우 중 빈 테이블이 있는 방향으로 다음 실행
         * B. 빈 테이블과 인접한 위치중 응시자가 있으면 거리두기를 지키지 않음
         */
        public int[] solution(String[][] places) {

            int line = places.length;

            int[] res = new int[line];

            for (int i = 0; i < line; i++) {
                String[] place = places[i];
                char[][] room = new char[line][];
                for (int j = 0; j < line; j++) {
                    room[j] = place[j].toCharArray();
                }

                // 거리두기 검사 후 res에 기록
                if (isDistanced(room)) {
                    res[i] = 1;
                } else {
                    res[i] = 0;
                }
            }

            return res;
        }

        private boolean isDistanced(char[][] room) {
            for (int y = 0; y < room.length; y++) {
                for (int x = 0; x < room[y].length; x++) {
                    if (room[y][x] != 'P') continue;
                    if (!isDistanced(room, x, y)) return false;
                }
            }
            return true;
        }

        private boolean isDistanced(char[][] room, int x, int y) {
            // 상 좌 우 하 : 0 1 2 3
            for (int d = 0; d < dx.length; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                    continue;
                }
                switch (room[ny][nx]) {
                    case 'P' : return false;
                    case 'O' :
                        if (isNextToVolunteer(room, nx, ny, 3 - d)) {
                            return false;
                        }
                        break;
                }
            }
            return true;
        }

        private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {

            for (int d = 0; d < dx.length; d++) {
                if(d == exclude) continue;

                int nx = x + dx[d];
                int ny = y + dy[d];
                if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                    continue;
                }
                if (room[ny][nx] == 'P') return true;
            }
            return false;
        }
    }
}

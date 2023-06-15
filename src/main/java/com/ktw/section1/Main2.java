package com.ktw.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 청소
 */
public class Main2 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String solution(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int k = Integer.parseInt(reader.readLine());

        return findLocation(map, k, 0, 0, n);
    }

    private static String findLocation(int[][] map, int k, int x, int y, int n) {
        int d = 3;
        while (k > 0) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if ((nx >= 0 && nx < n && ny >= 0 && ny < n) && map[nx][ny] == 0) {
                map[nx][ny] = 1;
                x = nx;
                y = ny;
            } else {
                d = (d + 1) % 4;
            }

            k--;
        }

        return x + " " + y;
    }

}

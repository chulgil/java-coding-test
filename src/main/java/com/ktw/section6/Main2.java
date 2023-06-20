package com.ktw.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * DFS : 줄다리기
 */
public class Main2 {

    private static boolean[][] relations;
    private static boolean[] visited;

    private static int answer;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        relations = new boolean[8][8];
        visited = new boolean[8];
        answer = 0;
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relations[nums[0]][nums[1]] = true;
            relations[nums[1]][nums[0]] = true;
        }

        for (int i = 1; i <= 7; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }
        return answer;
    }

    private static void dfs(int result, int L) {
        if (L == 7) {
            answer++;
            return;
        }

        for (int i = 1; i <= 7; i++) {
            int first = result % 10;
            if (!visited[i] && !relations[i][first] && !relations[first][i]) {
                visited[i] = true;
                dfs(result * 10 + i, L + 1);
                visited[i] = false;
            }
        }
    }
}

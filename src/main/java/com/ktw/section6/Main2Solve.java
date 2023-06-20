package com.ktw.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main2Solve {

    private static int[] ch;
    private static int[][] relation;

    private static int answer;

    private static Stack<Integer> pm;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        answer = 0;
        pm = new Stack<>();
        ch = new int[8];
        relation = new int[8][8];

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relation[nums[0]][nums[1]] = 1;
            relation[nums[1]][nums[0]] = 1;
        }

        dfs(0);
        return answer;
    }

    private static void dfs(int L) {
        if (L == 7) answer++;
        else {
            for (int i = 1; i < 8; i++) {
                if (!pm.isEmpty() && relation[pm.peek()][i] == 1) continue;
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    dfs(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }
}

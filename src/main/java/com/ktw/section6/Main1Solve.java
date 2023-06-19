package com.ktw.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 인프런 풀이 : 가장 가까운 큰수
 */
public class Main1Solve {

    private static boolean flag;

    private static int answer;

    private static int target;

    private static int m;
    private static int[] ch;

    private static List<Integer> nums;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        target = n;
        int temp = n;

        while (temp > 0) {
            int t = temp % 10;
            nums.add(t);
            temp = temp / 10;
        }
        nums.sort(Comparator.comparingInt(a -> a));
        m = nums.size();
        ch = new int[m];
        dfs(0, 0);

        if (!flag) return -1;
        return answer;
    }

    private static void dfs(int L, int number) {
        if (flag) return;
        if (L == m) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(L + 1, (number * 10) + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }
}

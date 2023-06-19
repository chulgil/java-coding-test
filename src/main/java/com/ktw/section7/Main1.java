package com.ktw.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 타일 점프
 */
public class Main1 {

    private static int answer = 0;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        answer = Integer.MAX_VALUE;
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bfs(nums);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void bfs(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        int jumpCount = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int s = 0; s < size; s++) {
                Integer cur = deque.poll();
                if (cur == nums.length - 1) {
                    answer = Math.min(answer, jumpCount);
                    return;
                }
                int cnt = nums[cur];
                for (int i = cur + 1; i <= cur + cnt; i++) {
                    deque.offer(i);
                }
            }
            jumpCount++;
        }
    }
}

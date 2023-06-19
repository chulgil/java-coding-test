package com.ktw.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 인프런 : 타일점프 풀이
 */
public class Main1Solve {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nums.length;
        int[] ch = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        ch[0] = 1;
        int L = 0;

        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                int x = deque.poll();
                for (int j = 0; j <= nums[x]; j++) {
                    int nx = x + j;
                    if (nx == n - 1) return L + 1;
                    if (nx < n && ch[nx] == 0) {
                        ch[nx] = 1;
                        deque.offer(nx);
                    }
                }
            }
            L++;
        }

        return -1;
    }


}

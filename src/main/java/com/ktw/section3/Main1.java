package com.ktw.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 자료구조 활용 : 최대 길이 연속 수열
 */
public class Main1 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int maxLength = 1;

        for (int j : input) {
            priorityQueue.offer(j);
        }
        int count = 1;
        int cur = priorityQueue.poll();
        while (!priorityQueue.isEmpty()) {
            int compare = priorityQueue.poll();
            if (cur + 1 == compare) {
                count++;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 1;
            }
            cur = compare;
        }

        return Math.max(maxLength, count);
    }
}

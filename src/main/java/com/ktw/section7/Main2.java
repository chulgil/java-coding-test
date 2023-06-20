package com.ktw.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 집으로 이동
 */
public class Main2 {

    private static boolean[] visited;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        int[] pool = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int home = Integer.parseInt(reader.readLine());
        visited = new boolean[10001];
        for (int i = 0; i < pool.length; i++) {
            visited[pool[i]] = true;
        }

        return bfs(a, b, home);
    }

    private static int bfs(int a, int b, int home) {
        Deque<Node> deque = new LinkedList<>();
        deque.offer(Node.of(0, false));
        int count = 0;
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                Node cur = deque.poll();
                if (cur.location == home) return count;
                if (cur.location >= 0 && cur.location < 10001 && !visited[cur.location]) {
                    if (!cur.move) {
                        deque.offer(Node.of(cur.location - b, true));
                    }
                    deque.offer(Node.of(cur.location + a, false));
                }
            }
            count++;
        }
        return -1;
    }

    record Node(int location, boolean move) {

        public static Node of(int location, boolean move) {
            return new Node(location, move);
        }
    }
}

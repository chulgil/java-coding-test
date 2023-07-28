package me.chulgil.cote.section3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 최대 길이 연속수열
 */
public class Main1Solve {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        int answer = 0;
        String[] line = reader.readLine().split("");
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < line.length; i++) {
            set.add(Integer.parseInt(line[i]));
        }

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int cnt = 0;
                while (set.contains(x)) {
                    x++;
                    cnt++;
                }
                answer = Math.max(answer, cnt);
            }
        }

        return answer;
    }
}

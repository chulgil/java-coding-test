package com.ktw.section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 가장 가까운 큰수
 */
public class Main1 {

    private static Set<Integer> numList;
    private static String[] compare;
    private static boolean[] visited;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        numList = new HashSet<>();
        String[] splitN = String.valueOf(n).split("");
        visited = new boolean[splitN.length];
        compare = new String[splitN.length];
        for (int i = 0; i < splitN.length; i++) {
            visited[i] = true;
            dfs(splitN, i, splitN.length, 0);
            visited[i] = false;
        }

        List<Integer> collectedNumList = numList.stream().sorted().collect(Collectors.toList());

        return collectedNumList.indexOf(n) == collectedNumList.size() - 1 ? -1 : collectedNumList.get(collectedNumList.indexOf(n) + 1);
    }

    private static void dfs(String[] splitN, int i, int n, int L) {
        compare[L] = splitN[i];
        if (L == n - 1) {
            numList.add(Integer.parseInt(String.join("", compare)));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(splitN, j, n, L + 1);
                visited[j] = false;
            }
        }
    }
}

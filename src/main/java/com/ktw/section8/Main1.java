package com.ktw.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 최소 비행료
 */
public class Main1 {

    private static int answer;
    private static List<List<Node>> nodeList;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader br) throws IOException {
        answer = Integer.MAX_VALUE;
        int n = Integer.parseInt(br.readLine());
        nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeList.add(new ArrayList<>());
        }

        int flightInfoCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < flightInfoCount; i++) {
            int[] flightInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodeList.get(flightInfo[0]).add(Node.of(flightInfo[1], flightInfo[2]));
        }

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<Node> nodes = nodeList.get(start);
        for (Node node : nodes) {
            findMinFlightCost(node, end, k, 0, 0);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void findMinFlightCost(Node start, int end, int k, int compare, int count) {
        compare += start.cost;
        if (start.node == end) {
            answer = Math.min(answer, compare);
            return;
        }
        if (count == k) {
            return;
        }
        for (Node node : nodeList.get(start.node)) {
            findMinFlightCost(node, end, k, compare, count + 1);
        }
    }


    static class Node {

        private final int node;
        private final int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public static Node of(int node, int cost) {
            return new Node(node, cost);
        }
    }
}

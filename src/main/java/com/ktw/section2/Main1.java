package com.ktw.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 시간 & 해싱 : 한 번만 사용한 최초문자
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
        String input = reader.readLine();
        Map<String, Integer> stringMap = new HashMap<>();
        String[] splitString = input.split("");
        for (String s : splitString) {
            stringMap.put(s, stringMap.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < splitString.length; i++) {
            if (stringMap.get(splitString[i]) == 1) {
                return i + 1;
            }
        }

        return -1;
    }
}

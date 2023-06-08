package com.ktw.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 침몰하는 타이타닉
 * 유람선에는 N명의 승객이 타고 있습니다.
 * 구명보트는 2명이하만 탈 수 있다. 총 무게도 m kg이하만 탈 수 있다.
 * 구명보트의 최소개수
 */
public class Main1 {


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader br) throws IOException {
        int answer = 0;
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        int left = 0;
        int right = nums.length-1;

        while (left<right){
            if(nums[left] + nums[right]<=m){
                answer++;
                left++;
                right--;
            }else if(nums[left]+nums[right]>m){
                right--;
                answer++;
            }
        }

        return answer;
    }
}

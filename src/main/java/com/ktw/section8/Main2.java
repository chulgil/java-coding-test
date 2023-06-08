package com.ktw.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 이동횟수
 *
 * 현수는 n개의 물건 A -> B
 * 한번에 5kg 이하만 들고 이동할 수 있습니다.
 * 최소이동횟수
 */
public class Main2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(BufferedReader br) throws IOException{
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int answer = 0;
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            if(nums[left]+nums[right] <= 5){
                answer++;
                left++;
                right--;
            }else{
                right--;
                answer++;
            }
        }

        return answer;
    }
}

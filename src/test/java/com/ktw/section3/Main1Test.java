package com.ktw.section3;

import static com.ktw.section3.Main1.solution;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ktw.common.TestFileUtil;
import java.io.BufferedReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자료구조 활용 : 최대 길이 연속 수열")
class Main1Test {


    @Test
    @DisplayName("최대 길이 연속 수열 - 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section3/main1/test_case1.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(5, solution);
    }

    @Test
    @DisplayName("최대 길이 연속 수열 - 케이스2")
    void test_case_2() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section3/main1/test_case2.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(10, solution);
    }
}
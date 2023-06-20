package com.ktw.section6;

import static com.ktw.section6.Main2.solution;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ktw.common.TestFileUtil;
import java.io.BufferedReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("줄다리기")
class Main2Test {

    @Test
    @DisplayName("줄다리기 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main2/test_case1.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(1968, solution);
    }

    @Test
    @DisplayName("줄다리기 케이스2")
    void test_case_2() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main2/test_case2.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(864, solution);
    }

    @Test
    @DisplayName("줄다리기 케이스3")
    void test_case_3() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main2/test_case3.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(720, solution);
    }

    @Test
    @DisplayName("줄다리기 케이스4")
    void test_case_4() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main2/test_case4.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(3600, solution);
    }

    @Test
    @DisplayName("줄다리기 케이스5")
    void test_case_5() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main2/test_case5.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(646, solution);
    }
}
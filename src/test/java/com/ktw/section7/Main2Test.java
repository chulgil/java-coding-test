package com.ktw.section7;

import static com.ktw.section7.Main2.solution;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ktw.common.TestFileUtil;
import java.io.BufferedReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("집으로 이동")
class Main2Test {


    @Test
    @DisplayName("집으로 이동 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section7/main2/test_case1.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(5, solution);
    }


    @Test
    @DisplayName("집으로 이동 케이스2")
    void test_case_2() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section7/main2/test_case2.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(5, solution);
    }

    @Test
    @DisplayName("집으로 이동 케이스3")
    void test_case_3() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section7/main2/test_case3.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(14, solution);
    }

    @Test
    @DisplayName("집으로 이동 케이스4")
    void test_case_4() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section7/main2/test_case4.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(-1, solution);
    }

    @Test
    @DisplayName("집으로 이동 케이스5")
    void test_case_5() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section7/main2/test_case5.txt");
        // when
        int solution = solution(reader);
        // then
        assertEquals(4, solution);
    }
}
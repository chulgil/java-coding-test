package me.chulgil.cote.section6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.chulgil.cote.common.TestFileUtil;
import java.io.BufferedReader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가장 가까운 큰수")
class Main1Test {


    @Test
    @DisplayName("가장 가까운 큰수 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main1/test_case1.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(132, solution);
    }

    @Test
    @DisplayName("가장 가까운 큰수 케이스2")
    void test_case_2() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main1/test_case2.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(-1, solution);
    }

    @Test
    @DisplayName("가장 가까운 큰수 케이스3")
    void test_case_3() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main1/test_case3.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(20735, solution);
    }

    @Test
    @DisplayName("가장 가까운 큰수 케이스4")
    void test_case_4() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main1/test_case4.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(71127, solution);
    }

    @Test
    @DisplayName("가장 가까운 큰수 케이스5")
    void test_case_5() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section6/main1/test_case5.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(54321, solution);
    }
}
package me.chulgil.cote.section5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.chulgil.cote.common.TestFileUtil;
import java.io.BufferedReader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("타이타닉 침몰")
class Main1Test {

    @Test
    @DisplayName("타이타닉 침몰 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section5/main1/test_case1.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(3, solution);
    }

    @Test
    @DisplayName("타이타닉 침몰 케이스2")
    void test_case_2() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section5/main1/test_case2.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(5, solution);
    }

    @Test
    @DisplayName("타이타닉 침몰 케이스3")
    void test_case_3() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section5/main1/test_case3.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(14, solution);
    }
}
package me.chulgil.cote.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.chulgil.cote.common.TestFileUtil;
import java.io.BufferedReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("시간&해싱 - 한 번만 사용한 최초문자")
class Main1Test {

    @Test
    @DisplayName("한 번만 사용한 최초문자 - 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section2/main1/test_case1.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(3, solution);
    }

    @Test
    @DisplayName("한 번만 사용한 최초문자 - 케이스2")
    void test_case_2() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section2/main1/test_case2.txt");
        // when
        int solution = Main1.solution(reader);
        // then
        assertEquals(-1, solution);
    }
}
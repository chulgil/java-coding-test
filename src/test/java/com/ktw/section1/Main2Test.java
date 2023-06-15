package com.ktw.section1;

import static com.ktw.section1.Main2.solution;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ktw.common.TestFileUtil;
import java.io.BufferedReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("청소")
class Main2Test {


    @Test
    @DisplayName("청소 케이스1")
    void test_case_1() throws Exception {
        // given
        BufferedReader reader = TestFileUtil.getReader(this.getClass(), "testcase/section1/main2/test_case1.txt");
        // when
        String solution = solution(reader);
        // then
        assertEquals("2 2", solution);
    }
}
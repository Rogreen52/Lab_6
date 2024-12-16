package com.example.lab_6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testExceptionThrown() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Invalid input");

        throw new IllegalArgumentException("Invalid input");
    }
}

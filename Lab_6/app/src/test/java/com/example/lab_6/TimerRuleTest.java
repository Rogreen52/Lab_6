package com.example.lab_6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TimerRuleTest {

    @Rule
    public TestRule timerRule = new TestRule() {
        @Override
        public Statement apply(Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    long startTime = System.currentTimeMillis();
                    base.evaluate();
                    long endTime = System.currentTimeMillis();
                    System.out.println("Test executed in " + (endTime - startTime) + " ms");
                }
            };
        }
    };

    @Test
    public void testSomething() {

        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
}

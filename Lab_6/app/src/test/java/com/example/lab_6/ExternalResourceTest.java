package com.example.lab_6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class ExternalResourceTest {

    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() {
            System.out.println("Setting up the resource...");
        }

        @Override
        protected void after() {
            System.out.println("Cleaning up the resource...");
        }
    };

    @Test
    public void testUsingExternalResource() {
        System.out.println("Test method executed.");
    }
}

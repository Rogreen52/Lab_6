package com.example.lab_6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class MyUnitTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();  // @Rule for temporary folder

    @Test
    public void testCreateTemporaryFile() throws IOException {
        // Create a temporary file using the TemporaryFolder rule
        File tempFile = folder.newFile("temp.txt");
        System.out.println("Temporary file created at: " + tempFile.getAbsolutePath());
    }
}


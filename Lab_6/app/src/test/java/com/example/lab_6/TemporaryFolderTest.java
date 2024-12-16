package com.example.lab_6;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class TemporaryFolderTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testCreateFile() throws IOException {
        File createdFile = folder.newFile("testfile.txt");
        System.out.println("File created at: " + createdFile.getAbsolutePath());
    }
}

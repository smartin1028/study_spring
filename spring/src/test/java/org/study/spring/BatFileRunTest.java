package org.study.spring;

import org.junit.jupiter.api.Test;

import java.io.IOException;


public class BatFileRunTest {
    /*
            String batFilePath = "C:\\path\\to\\your\\script.bat";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", batFilePath);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            System.out.println("Bat file executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
     */

    @Test
    void testString() {
        String fullPathBatFilePath = "windowsScript\\maven_clear_and_install.bat";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", fullPathBatFilePath);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            System.out.println("Bat file executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

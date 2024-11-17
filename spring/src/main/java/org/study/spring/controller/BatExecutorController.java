package org.study.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
@Controller
public class BatExecutorController {

    @Value("${study.spring.bat02}")
    private String studySpringBat02;

    @GetMapping("/")
    public String home() throws IOException {

        ClassPathResource resource = new ClassPathResource("\\windowsScript\\maven_clear_and_install.bat");
        String s = StreamUtils.copyToString(resource.getInputStream(), Charset.forName("x-windows-949"));
        log.info("s = {}", s);

        return "index";
    }

    @PostMapping("/execute-bat")
    public String executeBat(Model model) throws IOException {
        ClassPathResource resource = new ClassPathResource("\\windowsScript\\maven_clear_and_install.bat");
        String fullPath = resource.getFile().getAbsolutePath();
        log.info("execute bat file run : {}" , fullPath);
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", fullPath);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            model.addAttribute("message", "Bat file executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            model.addAttribute("message", "Error executing bat file: " + e.getMessage());
        }
        log.info("execute bat file end");
        return "index";
    }

    @PostMapping("/execute-bat-1")
    public String executeBat1(Model model) throws IOException {
        ClassPathResource resource = new ClassPathResource("\\windowsScript\\script1.bat");
        String fullPath = resource.getFile().getAbsolutePath();
        log.info("execute bat file run : {}" , fullPath);
        String result = executeBatFile(fullPath);
        model.addAttribute("message1", result);
        return "index";
    }

    @PostMapping("/execute-bat-2")
    public String executeBat2(Model model) throws IOException {
        log.info("studySpringBat02 : {}", studySpringBat02);
        ClassPathResource resource = new ClassPathResource(studySpringBat02);
        String fullPath = resource.getFile().getAbsolutePath();
        log.info("execute bat file run : {}" , fullPath);
        String result = executeBatFile(fullPath);
        model.addAttribute("message2", result);
        return "index";
    }

    private String executeBatFile(String batFilePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", batFilePath);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            return "Exit code: " + exitCode;
        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }
    }
}
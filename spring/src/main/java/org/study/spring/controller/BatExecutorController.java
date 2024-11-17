package org.study.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class BatExecutorController {

    @GetMapping("/")
    public String home() throws IOException {

        ClassPathResource resource = new ClassPathResource("\\windowsScript\\maven_clear_and_install.bat");
        String s = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("s = " + s);

        return "index";
    }

    @PostMapping("/execute-bat")
    public String executeBat(Model model) throws IOException {
        ClassPathResource resource = new ClassPathResource("\\windowsScript\\maven_clear_and_install.bat");

        String fullPath = resource.getFile().getAbsolutePath();
        System.out.println("batFilePath = " + fullPath);
        log.info("execute bat file run");
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
}
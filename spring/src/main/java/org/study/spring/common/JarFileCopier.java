package org.study.spring.common;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.study.spring.common.DailyFolderCreator.createDailyFolder;

@Slf4j
public class JarFileCopier {
    public static void copyJarToDeployFolder(String sourceJarPath, String deployFolderPath) {
        try {
            Path sourcePath = Paths.get(sourceJarPath);
            Path targetPath = Paths.get(deployFolderPath, sourcePath.getFileName().toString());

            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

            log.info("JAR file successfully copied to: {}", targetPath);
        } catch (IOException e) {
            log.error("Error copying JAR file: {}", e.getMessage());
        }
    }


}
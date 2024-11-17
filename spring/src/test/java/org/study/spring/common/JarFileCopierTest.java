package org.study.spring.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static org.study.spring.common.DailyFolderCreator.createDailyFolder;

@Slf4j
class JarFileCopierTest {

    @Test
    void copyJarToDeployFolder() throws IOException {
        String basePath = "basePath";
        Path createdFolder = createDailyFolder(basePath);
        log.info("New folder created: " + createdFolder);
        String sourceJarPath = "sourceJarPath";
        String deployFolderPath = createdFolder.toAbsolutePath().toString();
        JarFileCopier.copyJarToDeployFolder(sourceJarPath, deployFolderPath);

    }
}
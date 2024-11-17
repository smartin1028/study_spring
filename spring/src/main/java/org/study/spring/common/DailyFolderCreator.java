package org.study.spring.common;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyFolderCreator {
    public static Path createDailyFolder(String basePath) throws IOException {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateString = today.format(formatter);

        Path baseFolder = Paths.get(basePath);
        String folderName = dateString + "-01";
        Path newFolder = baseFolder.resolve(folderName);

        int counter = 1;
        while (Files.exists(newFolder)) {
            counter++;
            folderName = String.format("%s-%02d", dateString, counter);
            newFolder = baseFolder.resolve(folderName);
        }

        Files.createDirectories(newFolder);
        System.out.println("Created folder: " + newFolder);
        return newFolder;
    }
}
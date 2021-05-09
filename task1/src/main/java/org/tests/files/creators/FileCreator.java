package org.tests.files.creators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class FileCreator {

    private final static String RESULT_FILE_NAME = "results_of_searching_files.txt";

    public static void createResultTxtFile(Path parentDir, List<Path> txtFiles)  {
        Path resultPath = Paths.get(parentDir.toString() + "\\" + RESULT_FILE_NAME);
        try {
            if (Files.exists(resultPath)) {
                Files.delete(resultPath);
            }
        } catch (IOException ex) {
            System.out.println("Error - deleting files: " + ex.getMessage());
        }

        try {
            Files.createFile(resultPath);
        } catch (IOException ex) {
            System.out.println("Error in creating file: " + ex.getMessage());
        }

        try {
            for (Path file : txtFiles) {
                Files.write(resultPath, Files.readAllBytes(file), StandardOpenOption.APPEND);
            }
        } catch (IOException ex) {
            System.out.println("Error in writing files into " + RESULT_FILE_NAME + " : " + ex.getMessage());
        }
    }
}

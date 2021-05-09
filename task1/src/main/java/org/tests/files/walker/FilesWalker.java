package org.tests.files.walker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FilesWalker {

    public static List<Path> findAllTextFiles(Path startDirectoryPath) {
        List<Path> res = null;
        try {
            res = Files.walk(startDirectoryPath)
                    .filter(path -> path.getFileName().toString().endsWith(".txt"))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("Internal error: " + ex.getMessage());
        }
        return res;
    }
}

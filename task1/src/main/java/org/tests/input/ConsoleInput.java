package org.tests.input;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleInput {
    private static boolean isDirectory(String directory) {
        Path path = Paths.get(directory);
        return Files.isDirectory(path);
    }

    public static String inputDirectory() {
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.nextLine();
        while (!isDirectory(directory)) {
            System.out.println("Указанной директории не существует! Введите корректный путь до директории!");
            directory = scanner.nextLine();
        }

        return directory;
    }
}

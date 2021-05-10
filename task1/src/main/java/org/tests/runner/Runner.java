package org.tests.runner;

import org.tests.files.creators.FileCreator;
import org.tests.files.walker.FilesWalker;
import org.tests.input.ConsoleInput;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        /*
        todo: Имеется корневая папка. В этой папке могут находиться текстовые файлы,
         а также другие папки. В других папках также могут находится текстовые файлы и
         папки (уровень вложенности может оказаться любым). Найти все текстовые файлы,
         отсортировать их по имени и склеить содержимое в один текстовый файл.
         */
        //1. считать путь до файла и убедиться, что путь задан корректно и такая директория существует
        String directory = ConsoleInput.inputDirectory();
        //2. совершить сам обход и найти файлы
        Path startDir = Paths.get(directory);
        List<Path> pathList = FilesWalker.findAllTextFiles(startDir);
        //3. отсортировать файлы
        pathList.sort((x, y) -> x.getFileName().toString().compareTo(y.getFileName().toString()));
        //4. составить результирующий текстовый файл
        FileCreator.createResultTxtFile(startDir, pathList);

    }
}

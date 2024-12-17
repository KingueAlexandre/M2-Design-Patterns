package fr.uge.poo.paint.ex5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseFileToArray {
    private final String pathFile;
    private final Path filePath;
    private final List<String> linesInFile;

    ParseFileToArray(String pathFile) throws IOException {
        Objects.requireNonNull(pathFile);
        this.pathFile = pathFile;
        filePath = Paths.get(pathFile);

        try(Stream<String> lines = Files.lines(filePath)){
            linesInFile = lines.collect(Collectors.toList());
        }
    }

    public List<String> getLinesInFile() {
        return linesInFile;
    }

}

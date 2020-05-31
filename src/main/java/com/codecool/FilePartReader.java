package com.codecool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;


    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("Line error");

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder(1024);
        for (Object line : lines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public String readLines() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        String lines[] = read().split("\\.");
        for (int i = 0; i < lines.length; i++) {
            if(i+1 >= fromLine && i+1 <= toLine){
                stringBuilder.append(lines[i]).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

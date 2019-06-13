package com.java.patterns.behavioral.command;

public class TextFile {

    private String fileName;

    public TextFile(String fileName) {
        this.fileName = fileName;
    }

    public String open() {
        return "Opening file " + fileName;
    }

    public String save() {
        return "Saving file " + fileName;
    }
}

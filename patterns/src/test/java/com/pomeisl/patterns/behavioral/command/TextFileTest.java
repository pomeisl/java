package com.pomeisl.patterns.behavioral.command;

import com.java.patterns.behavioral.command.TextFile;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextFileTest {

    @Test
    public void givenTextFile_Open_ResultShouldContainsFileName() {
        TextFile textFile = new TextFile("testFileName");

        assertThat(textFile.open()).isEqualTo("Opening file testFileName");
    }

    @Test
    public void givenTextFile_Save_ResultShouldContainsFileName() {
        TextFile textFile = new TextFile("testFileName");

        assertThat(textFile.save()).isEqualTo("Saving file testFileName");
    }

}

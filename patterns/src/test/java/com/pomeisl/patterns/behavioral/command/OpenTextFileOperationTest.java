package com.pomeisl.patterns.behavioral.command;

import com.java.patterns.behavioral.command.OpenTextFileOperation;
import com.java.patterns.behavioral.command.TextFile;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OpenTextFileOperationTest {

    @Test
    public void givenOperation_Execute_ShouldCallOpenMethod() {
        TextFile textFileMock = mock(TextFile.class);

        new OpenTextFileOperation(textFileMock).execute();

        verify(textFileMock, times(1)).open();
    }

}

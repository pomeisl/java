package com.pomeisl.patterns.behavioral.command;

import com.java.patterns.behavioral.command.SaveTextFileOperation;
import com.java.patterns.behavioral.command.TextFile;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SaveTextFileOperationTest {

    @Test
    public void givenOperation_Execute_ShouldCallSaveMethod() {
        TextFile textFileMock = mock(TextFile.class);

        new SaveTextFileOperation(textFileMock).execute();

        verify(textFileMock, times(1)).save();
    }
}

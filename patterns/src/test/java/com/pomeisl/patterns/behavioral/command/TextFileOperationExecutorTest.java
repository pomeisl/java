package com.pomeisl.patterns.behavioral.command;

import com.java.patterns.behavioral.command.TextFileOperation;
import com.java.patterns.behavioral.command.TextFileOperationExecutor;
import org.junit.Test;

import java.util.List;

import static com.pomeisl.patterns.util.ReflectionUtil.getValueForField;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TextFileOperationExecutorTest {

    @Test
    public void givenExecutor_ExecuteOperation_ShouldAddToOperationsList() throws NoSuchFieldException, IllegalAccessException {
        TextFileOperation textFileOperation = mock(TextFileOperation.class);
        TextFileOperationExecutor executor = new TextFileOperationExecutor();

        executor.executeOperation(textFileOperation);

        List<TextFileOperation> textFileOperations = (List<TextFileOperation>) getValueForField(executor, "textFileOperations");
        assertThat(textFileOperations).containsOnly(textFileOperation);
    }

    @Test
    public void givenExecutor_ExecuteOperation_CallExecuteMethod() {
        TextFileOperation textFileOperation = mock(TextFileOperation.class);
        TextFileOperationExecutor executor = new TextFileOperationExecutor();

        executor.executeOperation(textFileOperation);

        verify(textFileOperation, times(1)).execute();
    }

}

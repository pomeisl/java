package com.pomeisl.patterns.memento;

import com.java.patterns.memento.Memento;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MementoTest {

    @Test
    public void givenMemento_Initialize_ShouldContainsState() {
        Memento memento = new Memento("testState");

        assertThat(memento.getSavedState()).isEqualTo("testState");
    }
}

package com.pomeisl.patterns.behavioral.memento;

import com.java.patterns.behavioral.memento.Caretaker;
import com.java.patterns.behavioral.memento.Memento;
import com.pomeisl.patterns.util.ReflectionUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CaretakerTest {

    @Test
    public void givenCaretaker_AddMemento_ShouldContains() throws NoSuchFieldException, IllegalAccessException {
        Caretaker caretaker = new Caretaker();
        Memento memento = new Memento("testState");
        caretaker.add(memento);

        List<Memento> mementos = (List<Memento>) ReflectionUtil.getValueForField(caretaker, "mementos");

        Assertions.assertThat(mementos).containsOnly(memento);
    }

    @Test
    public void givenCaretaker_AddMemento_ShouldReturnSameObject() {
        Caretaker caretaker = new Caretaker();
        Memento memento = new Memento("testState");
        caretaker.add(memento);

        Memento result = caretaker.get();

        assertThat(result).isEqualTo(memento);
    }

}

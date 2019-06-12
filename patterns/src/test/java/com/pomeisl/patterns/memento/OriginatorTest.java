package com.pomeisl.patterns.memento;

import com.java.patterns.memento.Memento;
import com.java.patterns.memento.Originator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OriginatorTest {

    @Test
    public void givenOriginator_SaveToMemento_MementoHasSameState() {
        Originator originator = new Originator();
        originator.setState("testState");

        Assertions.assertThat(originator
                .saveToMemento()
                .getSavedState())
                .isEqualTo(originator.getState());
    }

    @Test
    public void givenOriginator_SetStateMultipleTime_SuccessfullyChangeState() {
        Originator originator = new Originator();
        originator.setState("testState");
        originator.setState("differentState");

        Assertions.assertThat(originator.getState())
                .isEqualTo("differentState");
    }

    @Test
    public void givenOriginator_RestoreFromMemento_SuccessfullyRestore() {
        Originator originator = new Originator();
        originator.setState("testState");

        Memento snapshot = originator.saveToMemento();

        originator.setState("differentState");
        originator.restoreFromMemento(snapshot);

        Assertions.assertThat(originator.getState())
                .isEqualTo(snapshot.getSavedState());
    }
}

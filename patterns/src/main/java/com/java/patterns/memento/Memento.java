package com.java.patterns.memento;

import java.util.Objects;

public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getSavedState() {
        return state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }

}

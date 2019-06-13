package com.java.patterns.behavioral.memento;

import java.util.LinkedList;
import java.util.Queue;

public class Caretaker {

    private Queue<Memento> mementos = new LinkedList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get() {
        return mementos.peek();
    }

}

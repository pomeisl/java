package com.java.eventbus;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class EventBusTest {

    private static class TestEvent {

    }

    private static class TestEvent2 {

    }

    private static class TestEventListener {
        @ListenerMethod
        public void onEvent(TestEvent event) {

        }
        @ListenerMethod
        public void onEvent(TestEvent2 event) {

        }
    }

    @Test
    public void whenEventPosted_thenEventIsSuccessfullyPublishedToTheEventListener() {
        EventBus eventBus = new EventBus();
        TestEventListener eventListener = mock(TestEventListener.class);
        TestEvent event = new TestEvent();

        eventBus.register(eventListener);

        eventBus.emit(event);

        verify(eventListener, times(1)).onEvent(event);
    }

    @Test
    public void whenEventPosted_thenEventsAreSuccessfullyPublishedToTheEventListener() {
        EventBus eventBus = new EventBus();
        TestEventListener eventListener = mock(TestEventListener.class);
        TestEvent event1 = new TestEvent();
        TestEvent event2 = new TestEvent();

        eventBus.register(eventListener);

        eventBus.emit(event1);
        eventBus.emit(event2);

        verify(eventListener, times(1)).onEvent(event1);
        verify(eventListener, times(1)).onEvent(event2);
    }
}

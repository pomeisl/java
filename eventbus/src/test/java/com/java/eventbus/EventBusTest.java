package com.java.eventbus;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class EventBusTest {

    private static class TestEvent {

    }

    private static class TestEventListener {
        @ListenerMethod
        public void onEvent(TestEvent event) {

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
}

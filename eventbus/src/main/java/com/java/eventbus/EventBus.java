package com.java.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class EventBus {

    private static class EventHandler {
        private Object target;
        private Method handlerMethod;

        private EventHandler(Object target, Method handlerMethod) {
            this.target = target;
            this.handlerMethod = handlerMethod;
        }

        public Object handleEvent(Object event) throws InvocationTargetException, IllegalAccessException {
            return handlerMethod.invoke(target, event);
        }
    }

    private Map<Class<?>, List<EventHandler>> handlers = new HashMap<>();

    /**
     * @param listener
     * @throws NullPointerException if the listener is null.
     */
    public void register(Object listener) throws NullPointerException {
        Arrays.stream(Objects.requireNonNull(listener).getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(ListenerMethod.class))
                .map(method -> new EventHandler(listener, method))
                .forEach(handler -> Arrays.stream(handler.handlerMethod.getParameterTypes())
                        .forEach(clazz -> {
                            if (!handlers.containsKey(clazz)) {
                                handlers.put(clazz, new LinkedList<>());
                            }
                            handlers.get(clazz).add(handler);
                        }));
    }

    /**
     * @param event
     * @throws RuntimeException if the event publishing isn't successful.
     */
    public void emit(Object event) throws RuntimeException {
        List<EventHandler> eventHandlers = handlers.get(event.getClass());

        try {
            for (EventHandler handler : eventHandlers) {
                handler.handleEvent(event);
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Event publishing wasn't successful.", e);
        }
    }

}

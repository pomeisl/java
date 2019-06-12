package com.pomeisl.patterns.util;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static Object getValueForField(Object target, String field) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = target.getClass().getDeclaredField(field);
        declaredField.setAccessible(true);
        return declaredField.get(target);
    }

}

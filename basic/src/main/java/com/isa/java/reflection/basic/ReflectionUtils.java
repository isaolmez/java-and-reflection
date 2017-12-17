package com.isa.java.reflection.basic;

import java.lang.reflect.Method;

public class ReflectionUtils {

    public static Method getSupportedMethod(Class cls,
            String name,
            Class[] paramTypes)
            throws NoSuchMethodException {
        if (cls == null) {
            throw new NoSuchMethodException();
        }
        try {
            return cls.getDeclaredMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            return getSupportedMethod(cls.getSuperclass(), name, paramTypes);
        }
    }
}

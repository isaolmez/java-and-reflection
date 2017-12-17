package com.isa.java.reflection.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

    public static Method getSupportedMethod(Class cls, String name, Class[] paramTypes) throws NoSuchMethodException {
        if (cls == null) {
            throw new NoSuchMethodException();
        }

        try {
            return cls.getDeclaredMethod(name, paramTypes);
        } catch (NoSuchMethodException ex) {
            return getSupportedMethod(cls.getSuperclass(), name, paramTypes);
        }
    }

    public static Field[] getInstanceVariables(Class clazz) {
        List<Field> result = new ArrayList<>();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (!Modifier.isStatic(fields[i].getModifiers())) {
                    result.add(fields[i]);
                }
            }
            clazz = clazz.getSuperclass();
        }

        return result.toArray(new Field[result.size()]);
    }
}

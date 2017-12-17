package com.isa.java.reflection.basic.basics.lesson2_methods;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MethodIntrospectionTest {

    @Test
    public void shouldGetPublicMethodAsDeclared() {
        try {
            Method method = Animal.class.getDeclaredMethod("walk", new Class[]{});

            assertThat(method.getDeclaringClass()).isEqualTo(Animal.class);
            assertThat(method.getName()).isEqualTo("walk");
            assertThat(method.getReturnType()).isEqualTo(String.class);
            assertThat(method.getParameterCount()).isEqualTo(0);
            assertThat(method.getParameterTypes()).isEmpty();
        } catch (NoSuchMethodException e) {
            fail("Should have found the method");
        }
    }

    @Test
    public void shouldGetPublicMethod() {
        try {
            Method method = Animal.class.getMethod("walk", new Class[]{});

            assertThat(method.getDeclaringClass()).isEqualTo(Animal.class);
            assertThat(method.getName()).isEqualTo("walk");
            assertThat(method.getReturnType()).isEqualTo(String.class);
            assertThat(method.getParameterCount()).isEqualTo(0);
            assertThat(method.getParameterTypes()).isEmpty();
        } catch (NoSuchMethodException e) {
            fail("Should have found the method");
        }
    }

    @Test(expected = NoSuchMethodException.class)
    public void shouldNotGetPrivateMethod() throws NoSuchMethodException {
        Animal.class.getMethod("getAge", new Class[]{});
    }

    @Test
    public void shouldGetPrivateMethodAsDeclared() throws NoSuchMethodException {
        Animal.class.getDeclaredMethod("getAge", new Class[]{});
    }

    @Test
    public void shouldInvokeMethod() throws NoSuchMethodException {
        Animal animal = new Animal();
        Method method = Animal.class.getDeclaredMethod("eat", new Class[]{int.class});
        try {
            Integer result = (Integer) method.invoke(animal, new Object[]{new Integer(1)});
            assertThat(result).isEqualTo(2);
        } catch (IllegalAccessException e) {
            fail("Should have run");
        } catch (InvocationTargetException e) {
            fail("Should have run");
        }
    }

    public static class Animal {

        public String walk() {
            return "...";
        }

        public int eat(int i) {
            return i + 1;
        }

        private int getAge() {
            return 1;
        }
    }
}

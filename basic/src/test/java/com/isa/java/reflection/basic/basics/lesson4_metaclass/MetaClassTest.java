package com.isa.java.reflection.basic.basics.lesson4_metaclass;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MetaClassTest {

    @Test
    public void shouldBeInstance1() {
        assertThat(Class.class.isInstance(Class.class)).isTrue();

        assertThat(Class.class instanceof Class).isTrue();

        assertThat(Class.class instanceof Object).isTrue();
    }

    @Test
    public void shouldBeInstance3() {
        assertThat(Class.class.isInstance(Object.class)).isTrue();

        assertThat(Object.class instanceof Class).isTrue();

        assertThat(Object.class instanceof Object).isTrue();
    }

    @Test
    public void shouldBeInstance4() {
        assertThat(Class.class.isInstance(Dog.class)).isTrue();

        assertThat(Dog.class instanceof Class).isTrue();

        assertThat(Dog.class instanceof Object).isTrue();

        assertThat(new Dog() instanceof Dog).isTrue();

        assertThat(new Dog() instanceof Object).isTrue();
    }

    private static class Dog {

    }
}

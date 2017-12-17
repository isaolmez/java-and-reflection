package com.isa.java.reflection.basic.basics.lesson1_classes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PritimiteIntrospectionTest {

    @Test
    public void shouldReturnFeaturesForInt() {
        assertThat(int.class.isPrimitive()).isTrue();
        assertThat(int.class.isArray()).isFalse();
        assertThat(int.class.isInterface()).isFalse();
    }

    @Test
    public void shouldReturnFeaturesForInteger() {
        assertThat(Integer.class.isPrimitive()).isFalse();
        assertThat(Integer.class.isArray()).isFalse();
        assertThat(Integer.class.isInterface()).isFalse();
    }

    @Test
    public void shouldReturnFeaturesForVoid() {
        assertThat(void.class.isPrimitive()).isTrue();
        assertThat(void.class.isArray()).isFalse();
        assertThat(void.class.isInterface()).isFalse();
    }
}

package com.isa.java.reflection.basic.classes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayIntrospectionTest {

    @Test
    public void shouldReturnFeaturesForInt() {
        assertThat(int[].class.isPrimitive()).isFalse();
        assertThat(int[].class.isArray()).isTrue();
        assertThat(int[].class.isInterface()).isFalse();
    }

    @Test
    public void shouldReturnComponentType() {
        assertThat(int[].class.getComponentType()).isEqualTo(int.class);
    }

    @Test
    public void shouldReturnComponentTypeForMultiDimensioned() {
        assertThat(int[][].class.getComponentType()).isEqualTo(int[].class);
    }
}

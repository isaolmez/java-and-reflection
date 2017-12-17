package com.isa.java.reflection.basic.classes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InterfaceIntrospectionTest {

    @Test
    public void shouldReturnFeaturesForInt() {
        assertThat(Flying.class.isPrimitive()).isFalse();
        assertThat(Flying.class.isArray()).isFalse();
        assertThat(Flying.class.isInterface()).isTrue();
    }

    public interface Flying {

        int MILES = 10;

        void fly();
    }
}

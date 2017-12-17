package com.isa.java.reflection.basic.inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InheritanceTest {

    private Machine machine;
    private Car car;
    private Ferrari ferrari;

    @Before
    public void setUp() {
        machine = new Machine();
        car = new Car();
        ferrari = new Ferrari();
    }

    @Test
    public void shouldGetDirectSuperClass() {
        Ferrari ferrari = new Ferrari();
        Class<?> superClass;

        superClass = ferrari.getClass().getSuperclass();
        assertThat(superClass).isEqualTo(Car.class);

        superClass = ferrari.getClass().getSuperclass().getSuperclass();
        assertThat(superClass).isEqualTo(Machine.class);

        superClass = ferrari.getClass().getSuperclass().getSuperclass().getSuperclass();
        assertThat(superClass).isEqualTo(Object.class);

        superClass = ferrari.getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass();
        assertThat(superClass).isEqualTo(null);
    }

    @Test
    public void shouldGetDirectSuperInterfaces() {
        Ferrari ferrari = new Ferrari();
        Class<?>[] interfaces;

        interfaces = ferrari.getClass().getInterfaces();
        assertThat(interfaces.length).isEqualTo(1);
        assertThat(interfaces).contains(Fastest.class);

        interfaces = ferrari.getClass().getSuperclass().getInterfaces();
        assertThat(interfaces.length).isEqualTo(1);
        assertThat(interfaces).contains(Faster.class);

        interfaces = ferrari.getClass().getSuperclass().getSuperclass().getInterfaces();
        assertThat(interfaces.length).isEqualTo(1);
        assertThat(interfaces).contains(Fast.class);

        interfaces = ferrari.getClass().getSuperclass().getSuperclass().getSuperclass().getInterfaces();
        assertThat(interfaces.length).isEqualTo(0);
        assertThat(interfaces).isEmpty();
    }

    @Test
    public void shouldBeInstance() {
        assertThat(Machine.class.isInstance(machine)).isTrue();
        assertThat(Machine.class.isInstance(car)).isTrue();
        assertThat(Machine.class.isInstance(ferrari)).isTrue();

        assertThat(Car.class.isInstance(machine)).isFalse();
        assertThat(Car.class.isInstance(car)).isTrue();
        assertThat(Car.class.isInstance(ferrari)).isTrue();

        assertThat(Ferrari.class.isInstance(machine)).isFalse();
        assertThat(Ferrari.class.isInstance(car)).isFalse();
        assertThat(Ferrari.class.isInstance(ferrari)).isTrue();
    }

    @Test
    public void shouldBeInstanceForInterfaces() {
        assertThat(Fast.class.isInstance(machine)).isTrue();
        assertThat(Fast.class.isInstance(car)).isTrue();
        assertThat(Fast.class.isInstance(ferrari)).isTrue();

        assertThat(Faster.class.isInstance(machine)).isFalse();
        assertThat(Faster.class.isInstance(car)).isTrue();
        assertThat(Faster.class.isInstance(ferrari)).isTrue();

        assertThat(Fastest.class.isInstance(machine)).isFalse();
        assertThat(Fastest.class.isInstance(car)).isFalse();
        assertThat(Fastest.class.isInstance(ferrari)).isTrue();
    }

    @Test
    public void shouldBeAssignable() {
        assertThat(Machine.class.isAssignableFrom(Machine.class)).isTrue();
        assertThat(Machine.class.isAssignableFrom(Car.class)).isTrue();
        assertThat(Machine.class.isAssignableFrom(Ferrari.class)).isTrue();

        assertThat(Car.class.isAssignableFrom(Machine.class)).isFalse();
        assertThat(Car.class.isAssignableFrom(Car.class)).isTrue();
        assertThat(Car.class.isAssignableFrom(Ferrari.class)).isTrue();

        assertThat(Ferrari.class.isAssignableFrom(Machine.class)).isFalse();
        assertThat(Ferrari.class.isAssignableFrom(Car.class)).isFalse();
        assertThat(Ferrari.class.isAssignableFrom(Ferrari.class)).isTrue();
    }
}

class Machine implements Fast {

}

class Car extends Machine implements Faster {

}

class Ferrari extends Car implements Fastest {

}

interface Fast {

}

interface Faster extends Fast {

}

interface Fastest extends Faster {

}

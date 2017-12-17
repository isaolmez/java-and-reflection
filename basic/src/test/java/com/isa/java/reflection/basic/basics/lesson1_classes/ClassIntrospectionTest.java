package com.isa.java.reflection.basic.basics.lesson1_classes;


import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClassIntrospectionTest {

    private Person person;

    @Before
    public void setUp() {
        person = new Person();
        person.setName("John");
    }

    @Test
    public void shouldGetClass() {
        Class<? extends Person> actual = person.getClass();

        assertThat(actual).isEqualTo(Person.class);
    }

    @Test
    public void shouldGetSimpleName() {
        String actual = Person.class.getSimpleName();

        assertThat(actual).isEqualTo("Person");
    }

    @Test
    public void shouldGetName() {
        String actual = Person.class.getName();

        assertThat(actual).isEqualTo("com.isa.java.reflection.basic.basics.lesson1_classes.Person");
    }

    @Test
    public void shouldIncludeObjectMethods() {
        List<String> objectMethodNames = Lists.newArrayList("toString", "hashCode", "equals");
        Method[] methods = Person.class.getMethods();

        for (String objectMethod : objectMethodNames) {
            boolean present = Arrays.stream(methods)
                    .map(Method::getName)
                    .peek(System.out::println)
                    .filter(objectMethod::equals)
                    .findAny().isPresent();
            assertThat(present).isTrue();
        }
    }

    @Test
    public void shouldIncludeDeclaredMethods() {
        List<String> declaredMethods = Lists.newArrayList("setName", "setName");
        Method[] methods = Person.class.getDeclaredMethods();

        for (String declaredMethod : declaredMethods) {
            boolean present = Arrays.stream(methods)
                    .map(Method::getName)
                    .peek(System.out::println)
                    .filter(declaredMethod::equals)
                    .findAny().isPresent();
            assertThat(present).isTrue();
        }
    }

    @Test
    public void shouldReturnFeatures() {
        assertThat(Person.class.isPrimitive()).isFalse();
        assertThat(Person.class.isInterface()).isFalse();
        assertThat(Person.class.isArray()).isFalse();
        assertThat(Person.class.isLocalClass()).isFalse();
        assertThat(Person.class.isAnonymousClass()).isFalse();
        assertThat(Person.class.isMemberClass()).isFalse();
    }

    @Test
    public void shouldReturnFeaturesForLocalClass() {
        class MyLocal {

        }

        assertThat(MyLocal.class.isLocalClass()).isTrue();
        assertThat(MyLocal.class.isAnonymousClass()).isFalse();
        assertThat(MyLocal.class.isMemberClass()).isFalse();
    }

    @Test
    public void shouldReturnFeaturesForAnonymousClass() {
        Object instance = new Object() {
        };

        assertThat(instance.getClass().isLocalClass()).isFalse();
        assertThat(instance.getClass().isAnonymousClass()).isTrue();
        assertThat(instance.getClass().isMemberClass()).isFalse();
    }

    @Test
    public void shouldBeCompatible() {
        assertThat(Person.class instanceof Class).isTrue();
    }

    @Test
    public void shouldBeCompatible2() {
        assertThat(Class.class.isInstance(Person.class)).isTrue();
    }
}

class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
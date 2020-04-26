package com.baeldung.ls.spel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpELTest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void whenSpELBeanA_thenAllResolvedCorrectly() {
        assertEquals(5, spELBeanA.getAdd());
    }

    @Test
    public void nateRocks() {
        assertEquals("Nate Rocks", spELBeanA.getNateRocks());
    }

    @Test
    public void aOrb() {
        assertEquals("a", spELBeanA.getaOrb());
    }

    @Test
    public void beanAAccessesBeanB() {
        assertEquals(10, spELBeanA.getBeanBProp1());
    }

}
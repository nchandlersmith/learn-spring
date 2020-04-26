package com.baeldung.ls.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanB {

    @Value("#{10}")
    private Integer prop1;

    public Integer getProp1() {
        return prop1;
    }

}
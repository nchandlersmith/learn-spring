package com.baeldung.ls.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanA {

    @Value("#{2 + 3}")
    private Integer add;

    @Value("#{'Nate' + ' ' + 'Rocks'}")
    private String nateRocks;

    @Value("#{3 > 2 ? 'a' : 'b'}")
    private String aOrb;

    @Value("#{spELBeanB.prop1}")
    private Integer beanBProp1;

    public Integer getAdd() {
        return add;
    }

    public String getNateRocks() {
        return nateRocks;
    }

    public String getaOrb() {
        return aOrb;
    }

    public Integer getBeanBProp1() {
        return beanBProp1;
    }

}
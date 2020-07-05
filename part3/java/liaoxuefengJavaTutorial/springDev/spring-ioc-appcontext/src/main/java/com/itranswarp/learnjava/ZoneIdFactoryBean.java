package com.itranswarp.learnjava;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class ZoneIdFactoryBean implements FactoryBean {

    String zone = "Z";

    @Override
    public Object getObject() throws Exception {
        return ZoneId.of(zone);
    }

    @Override
    public Class<?> getObjectType() {
        return ZoneId.class;
    }
}

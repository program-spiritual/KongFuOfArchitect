package com.learnjava.www.createPatterns.abstractFactoryMethod;

import java.io.IOException;
import java.nio.file.Path;

public class GoodWordDocument implements WordDocument {
    public GoodWordDocument(String md) {
    }

    @Override
    public void save(Path path) throws IOException {

    }
}

package com.learnjava.www.createPatterns.abstractFactoryMethod;

import java.io.IOException;
import java.nio.file.Path;

public class GoodHtmlDocument implements HtmlDocument {
    public GoodHtmlDocument(String md) {
    }

    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(Path path) throws IOException {

    }
}

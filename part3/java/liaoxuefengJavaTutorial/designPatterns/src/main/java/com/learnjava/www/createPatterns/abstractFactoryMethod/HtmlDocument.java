package com.learnjava.www.createPatterns.abstractFactoryMethod;

import java.io.IOException;
import java.nio.file.Path;

public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;
}

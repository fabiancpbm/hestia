package br.com.chongroup.hestia.parser;

import java.io.File;
import java.util.Map;

public class ParserRunner {

    private String testName;
    private Map<String, File> expectedFileMapping;
    private Map<String, File> actualFileMapping;

    public void run(String testFilePath) {
        this.expectedFileMapping = buildExpectedFileMapping();
        this.actualFileMapping = buildActualFileMapping();
    }

    private Map<String, File> buildExpectedFileMapping() {
        return null;
    }

    private Map<String, File> buildActualFileMapping() {
        return null;
    }
}

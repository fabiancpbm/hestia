package br.com.chongroup.hestia.parser;

import java.util.List;

public class ParserTestMetadata {
    private String testName;
    private String thingSource;

    private List<String> expected;

    public String getTestName() {
        return testName;
    }

    public String getThingSource() {
        return thingSource;
    }

    public List<String> getExpected() {
        return expected;
    }
}

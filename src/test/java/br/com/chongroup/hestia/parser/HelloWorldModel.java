package br.com.chongroup.hestia.parser;

public class HelloWorldModel {
    private String testName;
    private String thingSource;

    public String getTestName() {
        return testName;
    }

    public String getThingSource() {
        return thingSource;
    }

    @Override
    public String toString() {
        return "HelloWorldModel{" +
                "testName='" + testName + '\'' +
                ", thingSource='" + thingSource + '\'' +
                '}';
    }
}

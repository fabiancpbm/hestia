package br.com.chongroup.hestia.parser;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ParserTest {

    int count = 0;

    boolean value = false;

    @Test
    public void helloTestFunction() throws IOException, ParseException {
        ParserTestMetadata parserTestMetadata = ParserTestTool.readParserTestMetadata();
        ParserTestTool.runParser(parserTestMetadata);
        Assert.assertTrue(ParserTestTool.match(parserTestMetadata));
    }
}

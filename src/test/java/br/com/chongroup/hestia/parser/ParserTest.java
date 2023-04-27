package br.com.chongroup.hestia.parser;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ParserTest {

    @Test
    public void helloTestFunction() throws IOException, MavenInvocationException {
        Assert.assertTrue(ParserTestTool.runTest());
    }
}

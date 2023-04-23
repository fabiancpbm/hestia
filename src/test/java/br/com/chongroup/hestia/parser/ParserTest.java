package br.com.chongroup.hestia.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;

import static org.junit.Assert.*;
public class ParserTest {

    int count = 0;

    boolean value = false;

    @Before
    public void setVar() {
        System.out.println(++count);
        this.value = true;
    }

    @After
    public void clearVar() {
        System.out.println(++count);
        this.value = false;
    }

    @Test
    public void test() {
        assertTrue(this.value);
    }

    @Test
    public void test2() {
        assertTrue(this.value);
    }

    @Test
    public void test3() throws FileNotFoundException {
//        new ThingComp(new java.io.FileInputStream("/Users/fabian.brandao/dev/chon/hestia/src/test/hestia/smart-home.thing"));
//        ThingComp.ThingBody();
//        assertTrue(false);
    }
}

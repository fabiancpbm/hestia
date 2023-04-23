package br.com.chongroup.hestia.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldTest {

    int count = 0;

    boolean value = false;

    @Before
    public void setVar() {
    }

    @After
    public void clearVar() {
    }

    @Test
    public void helloTestFunction() throws FileNotFoundException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[0].getMethodName();

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(
                System.getProperty("user.dir") +
                        File.separator +
                        "src/test/resources" +
                        File.separator +
                        "br/com/chongroup/hestia/parser/HelloWorldTest.json"));
        List<HelloWorldModel> helloWorldModelList = gson.fromJson(reader, new TypeToken<ArrayList<HelloWorldModel>>(){}.getType());
        HelloWorldModel helloWorldModel = helloWorldModelList.stream().filter(e -> methodName.equals(e.getTestName())).findAny().orElse(null);

        System.out.println(helloWorldModel);
    }

    @Test
    public void helloWorldS() throws FileNotFoundException {

//        new ThingComp(new java.io.FileInputStream("/Users/fabian.brandao/dev/chon/hestia/src/test/hestia/smart-home.thing"));
//        ThingComp.ThingBody();
//        assertTrue(false);
    }
}

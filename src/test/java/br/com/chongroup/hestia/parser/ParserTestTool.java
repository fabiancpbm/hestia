package br.com.chongroup.hestia.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.InvocationRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserTestTool {

    private static final String RESOURCES_PATH = "src/test/resources";
    private static final String THING_PATH = "src/test/thing";

    public static ParserTestMetadata readParserTestMetadata() throws FileNotFoundException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[1];
        String methodName = stackTraceElement.getMethodName();
        String jsonFileName = stackTraceElement.getClassName().replaceAll("\\.", File.separator) + ".json";

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(
                System.getProperty("user.dir") +
                        File.separator +
                        RESOURCES_PATH +
                        File.separator +
                        jsonFileName));
        List<ParserTestMetadata> parserTestMetadataList = gson.fromJson(reader, new TypeToken<ArrayList<ParserTestMetadata>>(){}.getType());
        ParserTestMetadata parserTestMetadata = parserTestMetadataList.stream().filter(e -> methodName.equals(e.getTestName())).findAny().orElse(null);
        return parserTestMetadata;
    }

    public static void runParser(ParserTestMetadata parserTestMetadata) throws IOException, ParseException {
        Runtime.getRuntime().exec("mvn -version");
//        if (nao existe java) {
//            criar java
//        }
//        if (nao existe jar) {
//            cria jar
//        }
//
//        executar jar
//        new ThingComp(new java.io.FileInputStream(
//                System.getProperty("user.dir") +
//                        File.separator +
//                        THING_PATH +
//                        File.separator +
//                        parserTestMetadata.getThingSource()));
//        ThingComp.ThingBody();
    }

    public static boolean match(ParserTestMetadata parserTestMetadata) {
        for (String expected : parserTestMetadata.getExpected()) {
            File file = new File(System.getProperty("user.dir") +
                    File.separator +
                    "projetinho" + File.separator + "Project" + File.separator +
                    expected);
            if (!file.exists()) {
                return false;
            }
        }
        return true;
    }
}

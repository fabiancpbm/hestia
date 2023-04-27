package br.com.chongroup.hestia.parser;

import org.apache.maven.shared.invoker.*;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class ParserTestTool {

    private static final String RESOURCES_PATH = "src/test/resources";
    private static final String TARGET_PATH = "target";

    public static boolean runTest() throws MavenInvocationException, IOException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[1];
        String classPath = stackTraceElement.getClassName().replaceAll("\\.", File.separator);
        String methodName = stackTraceElement.getMethodName();

        generateParserJar();
        runParserJar(classPath, methodName);

        String expectedPath = getAbsolutePath(RESOURCES_PATH, classPath, methodName, "expected");
        String actualPath = getAbsolutePath("projetinho", "Project");
        return match(expectedPath, actualPath);
    }

    private static boolean match(String expectedPath, String actualPath) {
        File expectedFile = new File(expectedPath);
        if (expectedFile.isFile()) {
            String actualFilePath = actualPath + File.separator + expectedFile.getAbsolutePath().substring(expectedPath.length());
            String actualContent = readFile(actualFilePath);

            String expectedContent = readFile(expectedFile.getAbsolutePath());

            System.out.println(expectedContent);
            System.err.println("=====");
            System.out.println(actualContent);
            return false;
        }

        for (File file : expectedFile.listFiles()) {
            if (!match(file.getAbsolutePath(), actualPath)) {
                return false;
            }
        }
        return true;
    }

    private static String readFile(String filePath) {
        try {
            BufferedReader  reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            return null;
        }
    }

    private static void generateParserJar() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File(System.getProperty("user.dir") + File.separator + "pom.xml"));
        request.setGoals(Arrays.asList("compile", "assembly:single"));
        Invoker invoker = new DefaultInvoker();
        invoker.execute(request);
    }

    private static void runParserJar(String classPath, String methodName) throws IOException {
        Properties properties = new Properties();
        properties.load(ParserTestTool.class.getClassLoader().getResourceAsStream("pom.properties"));
        String jarName = properties.getProperty("artifact") + "-" + properties.getProperty("version") + "-jar-with-dependencies" + ".jar";
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("java -jar " +  getAbsolutePath(TARGET_PATH, jarName) + " " + getAbsolutePath(RESOURCES_PATH, classPath, methodName + ".thing"));
    }

    private static String getAbsolutePath(String... relativePath) {
        StringBuilder absolutePath = new StringBuilder(System.getProperty("user.dir"));
        for (String path : relativePath) {
            absolutePath.append(File.separator).append(path);
        }
        return absolutePath.toString();
    }
}

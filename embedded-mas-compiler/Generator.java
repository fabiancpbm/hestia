public class Generator {

    public static void buildFile(String name, String content) {
        java.io.File file = new java.io.File(name);
        try {
            if (file.createNewFile()) {
                java.io.FileWriter myWriter = new java.io.FileWriter(name);
                myWriter.write(content);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            }
        } catch (java.io.IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

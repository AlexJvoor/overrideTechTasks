package joke;

import java.io.*;
import java.nio.file.Files;

public class Main {
    static void createJokeFileToPath(File dir) {
        try {
            OutputStream outputStream = Files.newOutputStream(
                    new File(dir.getAbsolutePath() + "/joke.java").toPath());
            String joke = ("\n" +
                    "class Joke {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        System.out.println(\"Hello world!\");\n" +
                    "    }\n" +
                    "}\n");
            outputStream.write(joke.getBytes());
        } catch (IOException e){
            System.out.println("Error by creating file\n");
        }
    }

    static void jokeIter(File file) {
        createJokeFileToPath(file);
        String[] subFileNames = file.list();
        File subFile;
        for (String subFileName : subFileNames) {
            if ((subFile = new File(file.getPath() + '/' + subFileName)).isDirectory()) {
                jokeIter(subFile);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        jokeIter(file);
    }
}

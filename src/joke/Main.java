package joke;

import java.io.*;

public class Main {
    static void createJokeFileToPath(File dir) {
        try {
            File file = new File(dir.getAbsolutePath() + "/joke.java");
            OutputStream outputStream = new FileOutputStream(file);
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

    static boolean isSubDirs(File file) { //TODO refactor
        try {
            return file.listFiles(File::isDirectory).length != 0;
        } catch (NullPointerException e) {
            return false;
        }
    }

    static void iterFileList(File[] list) {
        for (File file : list) {
            if(isSubDirs(file)) {
                iterFileList(dirsList(file));
            }
            createJokeFileToPath(file);
        }
    }

    static File[] dirsList(File file) {
        File[] dirs = file.listFiles(File::isDirectory);
        return dirs;
    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        File[] mainList = dirsList(file);
        iterFileList(mainList);
    }
}

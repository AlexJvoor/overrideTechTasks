package ecoUser;

import java.io.*;

public class DataFile {

    public static String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(file)) {
            int tmp;
            while ((tmp = fis.read()) != -1) {
                sb.append((char) tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String processData(String data, int maxResourceUse) {
        String[] persons = data.split("\r\n");
        StringBuilder sb = new StringBuilder();
        sb.append(persons[0]).append('\n');
        for (int i = 1; i < persons.length; i++) {
            User user = new User(persons[i]);
            if (user.isEco(maxResourceUse)) {
                sb.append(persons[i]).append('\n');
            }
        }
        return sb.toString();
    }

    public static void saveDataToDir(File dir, String data) {
        try {
            FileOutputStream fos = new FileOutputStream(dir.getPath() +
                    "/result.csv");
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

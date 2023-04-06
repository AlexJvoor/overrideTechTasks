package ecoUser;

import java.io.*;

public class Main {

    public static String[] readWholeFileToStrings(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        int tmp;
        while ((tmp = fis.read()) != -1) {
            sb.append((char) tmp);
        }
        return sb.toString().split("\r\n");
    }

    public static void processData(File data, int maxResourceUse) {
        try {
            String[] persons = readWholeFileToStrings(data);
            FileOutputStream fos = new FileOutputStream(data.getParentFile().getPath() +
                    "/result_" + maxResourceUse + ".csv");
            fos.write((persons[0] + '\n').getBytes());
            User user = new User();
            for (int i = 1; i < persons.length; i++) {
                user.setParamsFromString(persons[i]);
                if (user.isEco(maxResourceUse)) {
                    fos.write((persons[i] + '\n').getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File data = new File(args[0]);
        int maxResourceUse = Integer.parseInt(args[1]);
        processData(data, maxResourceUse);
    }
}

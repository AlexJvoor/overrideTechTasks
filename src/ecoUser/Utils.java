package ecoUser;

import java.io.*;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<User> readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(file)) {
            int tmp;
            while ((tmp = fis.read()) != -1) {
                sb.append((char) tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] userStrings = sb.toString().split("\r\n");
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < userStrings.length; i++) {
            users.add(new User(userStrings[i]));
        }
        return users;
    }

    public static ArrayList<User> processData(ArrayList<User> users, int maxResourceUse) {
        ArrayList<User> ecoUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isEco(maxResourceUse)) {
                ecoUsers.add(user);
            }
        }
        return ecoUsers;
    }

    public static void saveDataToDir(File dir, ArrayList<User> ecoUsers) {
        String header = "id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2\n";
        try {
            FileOutputStream fos = new FileOutputStream(dir.getPath() +
                    "/result.csv");
            fos.write(header.getBytes());
            for (User ecoUser : ecoUsers) {
                fos.write(ecoUser.toString().getBytes());
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ecoUser;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File dataFile = new File(args[0]);
        int maxResourceUse = Integer.parseInt(args[1]);
        ArrayList<User> users = Utils.readFile(dataFile);
        ArrayList<User> ecoUsers = Utils.processData(users, maxResourceUse);
        Utils.saveDataToDir(dataFile.getParentFile(), ecoUsers);
    }
}

package ecoUser;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File dataFile = new File(args[0]);
        int maxResourceUse = Integer.parseInt(args[1]);
        String data = DataFile.readFile(dataFile);
        String result = DataFile.processData(data, maxResourceUse);
        DataFile.saveDataToDir(dataFile.getParentFile(), result);
    }
}

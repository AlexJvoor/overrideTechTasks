package ecoUser;

import java.io.*;

public class User implements Serializable {
    private final int id;
    private final String name;
    private final int waterCount;
    private final int gasCount1;
    private final int gasCount2;
    private final int electroCount1;
    private final int electroCount2;

    public User(String str) {
        String[] params = str.split("\\|");
        id = Integer.parseInt(params[0]);
        name = params[1];
        waterCount = Integer.parseInt(params[2]);
        gasCount1 = Integer.parseInt(params[3]);
        gasCount2 = Integer.parseInt(params[4]);
        electroCount1 = Integer.parseInt(params[5]);
        electroCount2 = Integer.parseInt(params[6]);
    }

    public String toString() {
        return id + "|" +
                name + "|" +
                waterCount + "|" +
                gasCount1 + "|" +
                gasCount2 + "|" +
                electroCount1 + "|" +
                electroCount2 + "\n";
    }

    public boolean isEco(int maxValue) {
        return (maxValue > waterCount &&
                maxValue > gasCount1 &&
                maxValue > gasCount2 &&
                maxValue > electroCount1 &&
                maxValue > electroCount2);
    }
}

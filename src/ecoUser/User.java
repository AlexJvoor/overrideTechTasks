package ecoUser;

import java.io.*;

public class User implements Serializable {
    private int id;
    private String name;
    private int waterCount;
    private int gasCount1;
    private int gasCount2;
    private int electroCount1;
    private int electroCount2;

    public void setParamsFromString(String str) {
        String[] params = str.split("\\|");
        id = Integer.parseInt(params[0]);
        name = params[1];
        waterCount = Integer.parseInt(params[2]);
        gasCount1 = Integer.parseInt(params[3]);
        gasCount2 = Integer.parseInt(params[4]);
        electroCount1 = Integer.parseInt(params[5]);
        electroCount2 = Integer.parseInt(params[6]);
    }

    public void writeObject(FileOutputStream fos) throws IOException {
        fos.write(this.toString().getBytes());
    }

    public String toString() {
        return new String(id + "\\|" +
                name + "\\|" +
                waterCount + "\\|" +
                gasCount1 + "\\|" +
                gasCount2 + "\\|" +
                electroCount1 + "\\|" +
                electroCount2);
    }

    public boolean isEco(int maxValue) {
        return (maxValue > waterCount &&
                maxValue > gasCount1 &&
                maxValue > gasCount2 &&
                maxValue > electroCount1 &&
                maxValue > electroCount2);
    }
}

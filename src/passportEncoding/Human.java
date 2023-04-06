package passportEncoding;

import java.io.*;

class Human implements Externalizable {
    String name;
    String passportNumber;

    Human (String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    private String encodeNumber(String number) {
        long input = Long.parseLong(number);
//        прибавления следующей цифры к предыдущей с остатком от деления на десять. Последнюю цифру шифровать не нужно.
//                Пример: 1789 -> 8579
        long result = 0;
        int tmp = (int)input % 10;
        String numberEncoded = new String();
        return numberEncoded;
    }

    private String secodeNumber(String numberEncoded) {
        String number = new String();
        return number;
    }
}


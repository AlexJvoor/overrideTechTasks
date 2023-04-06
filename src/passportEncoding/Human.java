package passportEncoding;

import java.io.Externalizable;
import java.io.Serializable;

class Human implements Serializable {
    String name;
    String passportNumber;

    Human (String name, String passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }
}


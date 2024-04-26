package dk.kea.dat3js.hogwarts5.person;

import java.sql.SQLOutput;
import java.util.Arrays;

public interface personWithNames {


    String getFirstName();
    String getMiddleName();
    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + (getMiddleName() != null ? getMiddleName() + " " : "") + getLastName();
    }



    default String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (str.contains(" ")){
            String[] words = str.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i] = capitalize(words[i]);
            }
            return String.join(" ", words);
        }
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    void setFirstName(String firstName);
    void setMiddleName(String middleName);
    void setLastName(String lastName);



    default String setFullName(String fullName) {
        if (fullName == null) {
            fullName = "";
        }

        String[] names = fullName.split(" ");
        if (names.length == 0) {
            return "";
        }

        setFirstName(names[0]);
        if (names.length > 2) {
            setMiddleName("");
            for (int i = 1; i < names.length - 1; i++) {
                if (i == 1) {
                    setMiddleName(getMiddleName() + names[i]);
                } else {
                    setMiddleName(getMiddleName() + " " + names[i]);
                }
                setLastName(names[names.length - 1]);
            }
        } else if(names.length > 1){
            setLastName(names[1]);
            setMiddleName(null);
        } else {
            setLastName(null);
            setMiddleName(null);
        }
        return getFullName();
    }

}

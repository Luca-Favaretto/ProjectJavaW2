package org.example;

import org.example.classes.Storage;
import org.example.utils.Periodicity;
import org.example.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    static List<Storage> storage = new ArrayList<>();


    public static void main(String[] args) {

        Utility.addElement("titolo", 20, "autore", "trash", storage);
        Utility.addElement("titolo", 20, Periodicity.MONTHLY, storage);


    }

}

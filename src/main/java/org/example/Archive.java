package org.example;

import org.example.classes.Storage;
import org.example.utils.Periodicity;
import org.example.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    static private List<Storage> storage = new ArrayList<>();

    public static void main(String[] args) {

        Utility.addElement("titolo", 20, "author", "trash", storage);
        Utility.addElement("titolo", 20, "author", "trash", storage);
        Utility.addElement("titolo", 20, Periodicity.MONTHLY, storage);


        System.out.println("Before elimination");
        storage.forEach(System.out::println);


        Utility.removeElement(storage.get(0).getCodISBN(), storage);

        System.out.println("After elimination");
        storage.forEach(System.out::println);


        System.out.println("Result of ID");
        Utility.findByISBN(storage.get(0).getCodISBN(), storage);

        System.out.println("Result of year of Publication");
        Utility.findByYearPublication(storage.get(0).getYearPublication(), storage);

        System.out.println("Result of Author");
        Utility.findByAuthor("author", storage);


    }

}

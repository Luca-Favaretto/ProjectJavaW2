package org.example.utils;

import org.example.classes.Book;
import org.example.classes.Magazine;
import org.example.classes.Storage;


import java.util.List;
import java.util.function.BiPredicate;

public class Utility {

    static BiPredicate<Long, Storage> correctCodISBN = (codISBN, elem) -> elem.getCodISBN() == codISBN;


    static public void addElement(String title, int numPages, String autor, String type, List<Storage> Storage) {
        title = title;
        numPages = numPages;
        autor = autor;
        type = type;
        Book book = new Book(title, numPages, autor, type);
        Storage.add(book);
        System.out.println("Success add " + book);
    }

    ;

    static public void addElement(String title, int numPages, Enum periodicity, List<Storage> Storage) {
        title = title;
        numPages = numPages;
        periodicity = periodicity;
        Magazine magazine = new Magazine(title, numPages, periodicity);
        Storage.add(magazine);
        System.out.println("Success add " + magazine);
    }

    ;;

    static public void removeElement(long codISBN, List<Storage> Storage) {
        if (Storage.removeIf(elem -> correctCodISBN.test(codISBN, elem))) {
            System.out.println("Success remove");
        } else {
            System.out.println("Didn't find book");
        }
    }

    ;

    static public Storage findByISBN(long codISBN, List<Storage> Storage) {
        List<Storage> list = Storage.stream().filter(elem -> correctCodISBN.test(codISBN, elem)).toList();
        Storage elem = list.get(0);
        System.out.println("Find" + elem);
        return elem;
    }

    ;

    static public void findByYearPublication() {
    }

    ;

    static public void findByAutor() {
    }

    ;

    static public void saveToDisk() {
    }

    ;

    static public void findToDisk() {
    }

    ;
}

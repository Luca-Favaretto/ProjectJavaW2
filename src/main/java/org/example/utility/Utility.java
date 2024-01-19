package org.example.utility;

import org.example.classes.Book;
import org.example.classes.Magazine;
import org.example.classes.Storage;


import java.util.List;
import java.util.function.BiPredicate;

public class Utility {
    static BiPredicate<Long, Storage> correctCodISBN = (codISBN, elem) -> elem.getCodISBN() == codISBN;



    static public void addElement(String title, int numPages, String autor, String type, List<Storage> Storage) {
        
        title = "";
        numPages = 20;
        autor = "";
        type = "";
        Book book = new Book(title, numPages, autor, type);
        Storage.add(book);
        System.out.println("Success add " + book);

    }

    ;

    static public void addElement(String title, int numPages, Enum periodicity, List<Storage> Storage) {
        title = "";
        numPages = 20;
        periodicity = Periodicity.MENSILE;
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

    static public void findByISBN(long codISBN, List<Storage> Storage) {
        Storage

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

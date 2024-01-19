package org.example.utils;

import org.example.classes.Book;
import org.example.classes.Magazine;
import org.example.classes.Storage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Utility {

    static BiPredicate<Long, Storage> correctCodISBN = (codISBN, elem) -> elem.getCodISBN() == codISBN;
    static BiPredicate<Integer, Storage> correctyearPublication = (yearPublication, elem) -> elem.getYearPublication() == yearPublication;
    static BiPredicate<String, Book> correctAuthor = (autor, elem) -> elem.getAuthor().equals(autor);


    static public void addElement(String title, int numPages, String autor, String type, List<Storage> Storage) {
//        title = title;
//        numPages = numPages;
//        autor = autor;
//        type = type;
        Book book = new Book(title, numPages, autor, type);
        Storage.add(book);
        System.out.println("Success add " + book);
    }


    static public void addElement(String title, int numPages, Enum periodicity, List<Storage> Storage) {
//        title = title;
//        numPages = numPages;
//        periodicity = periodicity;
        Magazine magazine = new Magazine(title, numPages, periodicity);
        Storage.add(magazine);
        System.out.println("Success add " + magazine);
    }


    static public void removeElement(long codISBN, List<Storage> storage) {
        if (storage.removeIf(elem -> correctCodISBN.test(codISBN, elem))) {
            System.out.println("Success remove");
        } else {
            System.out.println("Didn't find book");
        }
    }


    static public Storage findByISBN(long codISBN, List<Storage> storage) {
        List<Storage> list = storage.stream().filter(elem -> correctCodISBN.test(codISBN, elem)).toList();
        Storage elem = list.get(0);
        System.out.println("Find" + elem);
        return elem;
    }


    static public List<Storage> findByYearPublication(int yearPublication, List<Storage> storage) {
        List<Storage> list = storage.stream().filter(elem -> correctyearPublication.test(yearPublication, elem)).toList();
        list.forEach(System.out::println);
        return list;
    }


    static public List<Storage> findByAuthor(String author, List<Storage> storage) {
        List<Storage> list = storage.stream().filter(elem -> elem instanceof Book).filter(elem -> correctAuthor.test(author, (Book) elem)).toList();
        list.forEach(System.out::println);
        return list;
    }

    static public void saveToDisk(List<Storage> storage) throws IOException {
        StringBuilder toWrite = new StringBuilder();

        for (Storage product : storage) {
            toWrite.append(product.getTitle()).append("@").append(product.getYearPublication()).append("@").append(product.getNumPages()).append("#");

        }
        File file = new File("products.txt");
        FileUtils.writeStringToFile(file, toWrite.toString(), "UTF-8");
    }

    static public List<Storage> findToDisk() {
        File file = new File("products.txt");

        String fileString = FileUtils.readFileToString(file, "UTF-8");

        List<String> splitElementString = Arrays.asList(fileString.split("#"));

        return splitElementString.stream().map(stringa -> {

            String[] productInfos = stringa.split("@");
            return new Storage(productInfos[0], productInfos[1], Double.parseDouble(productInfos[2])) {
            };
        }).toList();

    }
}





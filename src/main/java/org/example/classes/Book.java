package org.example.classes;

public class Book extends Storage {

    private String autor;
    private String type;


    public Book(String title, int numPages, String autor, String type) {
        super(title, numPages);
        this.autor = autor;
        this.type = type;
    }
}

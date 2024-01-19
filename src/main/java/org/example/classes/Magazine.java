package org.example.classes;

public class Magazine extends Storage {
    private Enum periodicity;

    public Magazine(String title, int numPages, Enum periodicity) {
        super(title, numPages);
        this.periodicity = periodicity;
    }
}

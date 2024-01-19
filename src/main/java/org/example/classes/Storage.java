package org.example.classes;

import java.time.LocalDate;
import java.util.Random;

public abstract class Storage {
    private long codISBN;
    private String title;
    private int yearPublication;
    private int numPages;

    public Storage(String title, int numPages) {
        Random rnd = new Random();
        this.codISBN = rnd.nextLong();
        this.title = title;
        this.yearPublication = rnd.nextInt(1950, 2224);
        this.numPages = numPages;
    }

    public long getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(long codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(LocalDate yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }


}
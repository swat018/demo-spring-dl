package com.swat018.demospringdl;

public class BookService{

    BookRepository bookRepository;

    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }

    public void returnBook(Book book) {
        System.out.println("return: " + book.getTitle());
    }

}

package com.swat018.demospringdl;

public class BookService{

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void rent(Book book) {
//        System.out.println("rent: " + book.getTitle());
        Book save = bookRepository.save(book);
        System.out.println("rent: " + save.getTitle());
    }

    public void returnBook(Book book) {
//        System.out.println("return: " + book.getTitle());
        bookRepository.save(book);
        System.out.println("return: " + book.getTitle());

    }

}

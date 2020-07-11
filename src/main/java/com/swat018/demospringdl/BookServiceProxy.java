package com.swat018.demospringdl;

public class BookServiceProxy implements BookService {

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
/*        System.out.println("aaaa");
        bookService.rent(book);
        System.out.println("bbbb");*/

//        System.out.println("rent: Hibernate");
        System.out.println("aaaaa");
        bookService.rent(book);
        System.out.println("bbbbb");
    }

    @Override
    public void returnBook(Book book) {
        bookService.rent(book);
    }
}

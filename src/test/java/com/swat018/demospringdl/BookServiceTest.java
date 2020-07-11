package com.swat018.demospringdl;

import org.junit.Test;


public class BookServiceTest {

    BookService bookService = new BookServiceProxy(new DefalutBookService());

    @Test
    public void dl() {
/*        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);*/
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
    }
}
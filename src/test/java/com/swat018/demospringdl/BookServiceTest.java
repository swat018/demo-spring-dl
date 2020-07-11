package com.swat018.demospringdl;

import org.h2.util.json.JSONValidationTargetWithoutUniqueKeys;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BookServiceTest {

//    BookService bookService = new BookServiceProxy(new DefalutBookService());
    BookService bookService = (BookService)Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
        new InvocationHandler() {
            BookService bookService = new DefalutBookService();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("aaaaa");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("bbbbb");
                    return invoke;
                }

                return method.invoke(bookService, args);
            }
        })
;
    @Test
    public void dl() {
/*        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);*/
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }
}
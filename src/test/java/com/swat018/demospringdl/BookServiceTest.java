package com.swat018.demospringdl;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatcher;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BookServiceTest {

//    BookService bookService = new BookServiceProxy(new DefalutBookService());
/*
    BookService bookService = (BookService)Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
        new InvocationHandler() {
            BookService bookService = new BookService();
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
        });
*/
    @Test
    public void dl() throws Exception {
/*        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);*/
        // CGlib
/*
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new BookService();
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("rent")) {
                    System.out.println("aaaaa");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("bbbbb");
                    return invoke;
                }
                return method.invoke(bookService, args);
            }
        };
        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);
*/
        //ByteBuddy
 /*       Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookService bookService = new BookService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("aaaaa");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("bbbbb");
                        return invoke;
                    }
                }))
                .make().load(BookService.class.getClassLoader()).getLoaded();
        BookService bookService = proxyClass.getConstructor(null).newInstance();
*/
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        Book hibernateBook = new Book();
        hibernateBook.setTitle("Hibernate");
        when(bookRepositoryMock.save(any())).thenReturn(hibernateBook);

        BookService bookService = new BookService(bookRepositoryMock);

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }


}
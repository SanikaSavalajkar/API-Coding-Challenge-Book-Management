package com.hexaware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.entity.Book;
import com.hexaware.service.BookService;

@SpringBootTest
class BookManagementApplicationTests {

	@Autowired
    private BookService service;

    @Test
    void testAddAndRetrieveBook() {
        Book book = new Book("1234", "Spring Guide", "John", 2024);
        service.addBook(book);
        Assertions.assertTrue(service.getBookByIsbn("1234").isPresent());
    }
}

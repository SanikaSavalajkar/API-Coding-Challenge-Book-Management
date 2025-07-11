package com.hexaware.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.entity.Book;
import com.hexaware.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        return repository.findById(isbn);
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(String isbn, Book book) {
        if (!repository.existsById(isbn)) throw new RuntimeException("Book not found");
        book.setIsbn(isbn);
        return repository.save(book);
    }

    public void deleteBook(String isbn) {
        repository.deleteById(isbn);
    }
}
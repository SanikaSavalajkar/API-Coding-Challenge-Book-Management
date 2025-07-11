package com.hexaware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}

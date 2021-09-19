package com.api.book.bookDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

}

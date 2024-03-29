package com.ksmk.service;

import com.ksmk.model.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Long id);

    void delete(Long id);
}



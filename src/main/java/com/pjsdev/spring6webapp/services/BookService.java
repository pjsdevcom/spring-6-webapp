package com.pjsdev.spring6webapp.services;

import com.pjsdev.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}

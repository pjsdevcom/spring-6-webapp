package com.pjsdev.spring6webapp.services;

import com.pjsdev.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}

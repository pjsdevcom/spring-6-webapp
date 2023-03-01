package com.pjsdev.spring6webapp.repositories;

import com.pjsdev.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

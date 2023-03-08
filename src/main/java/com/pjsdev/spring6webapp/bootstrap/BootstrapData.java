package com.pjsdev.spring6webapp.bootstrap;

import com.pjsdev.spring6webapp.domain.Author;
import com.pjsdev.spring6webapp.domain.Book;
import com.pjsdev.spring6webapp.domain.Publisher;
import com.pjsdev.spring6webapp.repositories.AuthorRepository;
import com.pjsdev.spring6webapp.repositories.BookRepository;
import com.pjsdev.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author();
        author1.setFirstName("Mike");
        author1.setLastName("Williams");

        Book book1 = new Book();
        book1.setTitle("Sweet Days");
        book1.setIsbn("123456");

        Author author1saved = authorRepository.save(author1);
        Book book1saved = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstName("Adam");
        author2.setLastName("Jones");

        Book book2 = new Book();
        book2.setTitle("Late Bloomer");
        book2.setIsbn("456789");

        Author author2saved = authorRepository.save(author2);
        Book book2saved = bookRepository.save(book2);

        author1saved.getBooks().add(book1saved);
        author2saved.getBooks().add(book2saved);
        book1saved.getAuthors().add(author1saved);
        book2saved.getAuthors().add(author2saved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Thorex Publishing");
        Publisher savedPublisher = publisherRepository.save(publisher);

        book1saved.setPublisher(savedPublisher);
        book2saved.setPublisher(savedPublisher);

        authorRepository.save(author1saved);
        authorRepository.save(author2saved);

        bookRepository.save(book1saved);
        bookRepository.save(book2saved);

        System.out.println("In Bootstrap...");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());


        System.out.println("Publisher count: " + publisherRepository.count());
    }
}

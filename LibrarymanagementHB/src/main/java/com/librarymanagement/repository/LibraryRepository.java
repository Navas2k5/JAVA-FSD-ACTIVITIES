package com.librarymanagement.repository;

import com.librarymanagement.dto.BookWithAuthorInfoDto;
import com.librarymanagement.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertIntoBook(Book book) {
        entityManager.persist(book);
    }

    public Optional<Book> findBookById(Long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    public List<Book> getBookInfo() {
        String sql = """
                Select b from Book b 
                join b.author a
                left Join b.borrowedBy m
                """;
        return entityManager.createQuery(sql,Book.class).getResultList();
    }
}

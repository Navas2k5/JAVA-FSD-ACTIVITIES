package com.librarymanagement.service;

import com.librarymanagement.dto.BookWithAuthorInfoDto;
import com.librarymanagement.exception.ResourceNotFoundException;
import com.librarymanagement.mapper.LibraryMapper;
import com.librarymanagement.model.Book;
import com.librarymanagement.repository.LibraryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Transactional
    public void insertIntoBook(Book book) {
        libraryRepository.insertIntoBook(book);
    }

    public Book findBookById(Long id) {
        Optional<Book> optional = libraryRepository.findBookById(id);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Book not found");

        return optional.get();
    }

    public List<BookWithAuthorInfoDto> getBookInfo() {
        List<Book> books = libraryRepository.getBookInfo();
        return books.stream().map(LibraryMapper::mapEntitytoDto).toList();
    }
}

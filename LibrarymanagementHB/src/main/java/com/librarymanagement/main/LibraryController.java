package com.librarymanagement.main;

import com.librarymanagement.config.AppConfig;
import com.librarymanagement.dto.BookWithAuthorInfoDto;
import com.librarymanagement.enums.BookStatus;
import com.librarymanagement.enums.Genre;
import com.librarymanagement.model.Author;
import com.librarymanagement.model.Book;
import com.librarymanagement.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class LibraryController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LibraryService libraryService = context.getBean(LibraryService.class);

        // TASK 1 :----- INSERT INTO BOOK ------

        Author author = new Author();
        author.setId(1l);
        author.setCountry("United Kingdom");
        author.setName("J.K. Rowling");

        Book book = new Book();
        book.setAuthor(author);
        book.setGenre(Genre.FICTION);
        book.setStatus(BookStatus.AVAILABLE);
        book.setTitle("Harry Potter");
        book.setPublishedYear(1997);
        book.setBorrowedBy(null);

        //libraryService.insertIntoBook(book);
        System.out.println("Book Saved successfully");

        //TASK 2 :---- READ SINGLE BOOK BY BOOK ID ------

        Long id = 1l;
        Book singleBook = libraryService.findBookById(id);
        System.out.println(singleBook);

        //TASK 3 :----- FIND ALL BOOKS WITH AUTHOR AND MEMBER INFO USING DTO-----

        List<BookWithAuthorInfoDto> books= libraryService.getBookInfo();
        books.forEach(System.out :: println);





    }
}

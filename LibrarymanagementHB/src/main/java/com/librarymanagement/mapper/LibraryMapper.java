package com.librarymanagement.mapper;

import com.librarymanagement.dto.BookWithAuthorInfoDto;
import com.librarymanagement.model.Book;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {

    public static BookWithAuthorInfoDto mapEntitytoDto(Book book){
        return new BookWithAuthorInfoDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getName(),
                book.getBorrowedBy()!=null? book.getBorrowedBy().getName():null
        );
    }
}

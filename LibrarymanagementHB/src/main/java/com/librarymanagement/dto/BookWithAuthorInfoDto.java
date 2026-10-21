package com.librarymanagement.dto;

public record BookWithAuthorInfoDto(
        Long bookId,
    String bookName,
    String authorName,
    String borrowedBy
) {
}

package com.miniproject.onlineLibraryApplication.service;

import com.miniproject.onlineLibraryApplication.entity.BookEntity;
import com.miniproject.onlineLibraryApplication.model.BookModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    ResponseEntity<Object> create (BookModel bookModel);
    ResponseEntity<Object> update (String bookID, BookModel updatedBookModel);
    void delete (String bookID);
//    ResponseEntity<Object> findById (String bookID);
    List<BookEntity> getAllBooks ();

    BookEntity getBookByID(String bookID);

    List<BookEntity> getBookByAuthorName(String authorName);

    List<BookEntity> getBookByAuthorNameAndBookName(String authorName, String bookName);
}

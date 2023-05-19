package com.miniproject.onlineLibraryApplication.repository;

import com.miniproject.onlineLibraryApplication.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    List<BookEntity> getBookByAuthorName(String authorName);

    List<BookEntity> getBookByAuthorNameAndBookName(String authorName, String bookName);
}

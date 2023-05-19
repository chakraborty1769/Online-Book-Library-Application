package com.miniproject.onlineLibraryApplication.service.implementation;

import com.miniproject.onlineLibraryApplication.entity.BookEntity;
import com.miniproject.onlineLibraryApplication.model.BookModel;
import com.miniproject.onlineLibraryApplication.repository.BookRepository;
import com.miniproject.onlineLibraryApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    @Override
    public ResponseEntity<Object> create(BookModel bookModel) {
        BookEntity bookEntity = BookEntity.builder()
                .bookID(bookModel.getBookID())
                .bookType(bookModel.getBookType())
                .bookName(bookModel.getBookName())
                .authorName(bookModel.getAuthorName())
                .publishers(bookModel.getPublishers())
                .build();
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return new ResponseEntity<>(savedBookEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> update(String bookID, BookModel updatedBookModel) {
        BookEntity bookEntity = bookRepository.findById(bookID).get();
        bookEntity.setBookType(updatedBookModel.getBookType());
        bookEntity.setBookName(updatedBookModel.getBookName());
        bookEntity.setAuthorName(updatedBookModel.getAuthorName());
        bookEntity.setPublishers(updatedBookModel.getPublishers());
        return new ResponseEntity<>(bookRepository.save(bookEntity), HttpStatus.OK);
    }

    @Override
    public void delete(String bookID) {
        BookEntity bookEntity = bookRepository.findById(bookID).get();
        bookRepository.delete(bookEntity);
    }

    @Override
    public List<BookEntity> getAllBooks() {
//        List<BookEntity> bookModelList = bookRepository.findAll();
//        return bookModelList;
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBookByID(String bookID) {
        return bookRepository.findById(bookID).get();
    }

    @Override
    public List<BookEntity> getBookByAuthorName(String authorName) {
        return bookRepository.getBookByAuthorName(authorName);
    }

    @Override
    public List<BookEntity> getBookByAuthorNameAndBookName(String authorName, String bookName) {
        return bookRepository.getBookByAuthorNameAndBookName(authorName, bookName);
    }
}

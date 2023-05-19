package com.miniproject.onlineLibraryApplication.controller;

import com.miniproject.onlineLibraryApplication.entity.BookEntity;
import com.miniproject.onlineLibraryApplication.model.BookModel;
import com.miniproject.onlineLibraryApplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Object> create (@RequestBody BookModel bookModel){
        return bookService.create(bookModel);
    }
    @GetMapping("/all")
    public List<BookEntity> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/id/{bookID}")
    public BookEntity getBook(@PathVariable ("bookID")String bookID){
        return bookService.getBookByID(bookID);
    }
    @PutMapping("/update/{bookID}")
    public ResponseEntity<Object> update(@PathVariable ("bookID")String bookID, @RequestBody BookModel updatedBookModel){
        return bookService.update(bookID, updatedBookModel);
    }
    @DeleteMapping("/delete/{bookID}")
    public void delete (@PathVariable ("bookID")String bookID){
        bookService.delete(bookID);
    }
    @GetMapping("/author/{authorName}")
    public List<BookEntity> getBookByAuthor(@PathVariable ("authorName")String authorName){
        return bookService.getBookByAuthorName(authorName);
    }
    @GetMapping("/author/{authorName}/{bookName}")
    public List<BookEntity> getBookByBookName(@PathVariable ("authorName")String authorName, @PathVariable ("bookName")String bookName){
        return bookService.getBookByAuthorNameAndBookName(authorName, bookName);
    }
}

package com.miniproject.onlineLibraryApplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookModel {
    private String bookID;
    private String bookType;
    private String bookName;
    private String authorName;
    private String publishers;
}

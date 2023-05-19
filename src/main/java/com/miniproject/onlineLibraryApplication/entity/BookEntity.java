package com.miniproject.onlineLibraryApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {
    @Id
    @Column(name = "book_id")
    private String bookID;
    private String bookType;
    private String bookName;
    private String authorName;
    private String publishers;
}

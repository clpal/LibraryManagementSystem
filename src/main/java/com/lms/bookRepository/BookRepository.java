package com.lms.bookRepository;

import com.lms.bookModel.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

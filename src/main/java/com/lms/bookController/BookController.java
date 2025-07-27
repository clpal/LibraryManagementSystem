package com.lms.bookController;

import com.lms.bookModel.Book;
import com.lms.bookRepository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/hello")
   String helloStudent(){
        return "Hello Books";

    }
    // GET all book
    @GetMapping
public List<Book> getAllBooks(){
      return   bookRepository.findAll();
}

//POST new book
    @PostMapping
    public  Book createBook(@RequestBody Book book){
      return   bookRepository.save(book);
    }
    // GET book by ID
    @GetMapping("/{id}")
   public ResponseEntity <Book> getBookById(@PathVariable Long id){
      return   bookRepository.findById(id)
              .map(book ->ResponseEntity.ok(book)).
              orElse(ResponseEntity.notFound().build());

   }
    // PUT update book
    // PUT update book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return ResponseEntity.ok(bookRepository.save(book));
        }).orElse(ResponseEntity.notFound().build());
    }

     // DELETE book
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
         return bookRepository.findById(id).map(book -> {
             bookRepository.delete(book);
             return ResponseEntity.noContent().<Void>build();
         }).orElse(ResponseEntity.notFound().build());
     }

}

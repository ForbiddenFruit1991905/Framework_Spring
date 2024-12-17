package ru.example.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.task2.model.Book;
import ru.example.task2.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
//@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBook(){
        return  bookService.getAllBooks();
    }
}

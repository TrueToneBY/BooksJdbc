package ru.truetone.booksjdbc.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.truetone.booksjdbc.model.Books;
import ru.truetone.booksjdbc.service.BooksServices;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BooksControllers {

    @Autowired
    BooksServices booksServices;

    @GetMapping("/books")
    public String getAllBooks(){
        log.info("GetBooksAll_OK");
        return "учи блять матьчасть";
    }




}

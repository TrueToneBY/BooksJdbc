package ru.truetone.booksjdbc.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.truetone.booksjdbc.model.Books;
import ru.truetone.booksjdbc.service.BooksDAO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BooksControllers {

    @Autowired
    BooksDAO booksDAO;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        log.info("GetBooksAll_OK");
        return booksDAO.getBooks();
    }

    /**
     * N2 lessons
     * @return status 200 HttpStatus.OK
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello",HttpStatus.OK);
    }


    /**
     *
     * @param singleParamName HttpStatus.ACCEPTED
     * @return  status 202
     */
    @GetMapping("/withParams{singleParamName}")
    public ResponseEntity<String> withParams(@PathVariable String singleParamName) {
        return new ResponseEntity<>(singleParamName,HttpStatus.ACCEPTED);

    }

    /**
     *
     * @param id HttpStatus.CREATED
     * @return status 201
     */
    @GetMapping("/withPathVariable{id}")
    public ResponseEntity<String> withPathVariable (@PathVariable String id){
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }

    
    @PostMapping("/echo{id}")
    public ResponseEntity<?> echo(@PathVariable String id){
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }





}

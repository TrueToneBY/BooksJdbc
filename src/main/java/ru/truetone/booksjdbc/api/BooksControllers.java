package ru.truetone.booksjdbc.api;


import io.swagger.v3.oas.models.headers.Header;
import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.netty.http.server.HttpServerResponse;
import ru.truetone.booksjdbc.model.Books;
import ru.truetone.booksjdbc.service.BooksDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    
    @PostMapping(value = "/echo",produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> echo(){
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    /**
     * записать куки
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/set-cookie")
    public ResponseEntity<?> setCookie(HttpServletResponse response) throws IOException{
        Cookie cookie = new Cookie("data","Come_to_the_dark_side");//создаем объект Cookie,
        //в конструкторе указываем значения для name и value
        cookie.setPath("/");//устанавливаем путь
        cookie.setMaxAge(86400);//здесь устанавливается время жизни куки
        response.addCookie(cookie);//добавляем Cookie в запрос
        response.setContentType("text/plain");//устанавливаем контекст
        return ResponseEntity.ok().body(HttpStatus.OK);//получилось как бы два раза статус ответа установили,
        // выбирайте какой вариант лучше
    }

    /**
     * Чтение Cookie
     * @param data
     * @return
     */
    @GetMapping(value = "/get-cookie")
    public ResponseEntity<?> readCookie(@CookieValue(value = "data")String data){
        return ResponseEntity.ok().body(data);
    }

    /**
     * прочитать заголовки:
     * @param headers
     * @return
     */
    @GetMapping(value = "/get-headers")
    public ResponseEntity<?> getHeaders(@RequestHeader Map<String,String> headers){//представляет заголовки ввиде мапы,
        //где ключ это наименование заголовка, а значение мапы - это значение заголовка
        return ResponseEntity.ok(headers);
    }

    /**
     * //записать заголовок
     * @return
     */
    @GetMapping(value = "/set-header")
    public ResponseEntity<?> setHeader(){
        return ResponseEntity.ok().header("name- header","value-header").body(HttpStatus.OK);
    }

    /**
     * //еще варианты работы с заголовками
     * @return
     */
    @GetMapping(value = "/set-headers")
    public ResponseEntity<?> setHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();//создаем объект
        //который имплементирует мапу MultiValueMap<String, String>
        //наполняем ее парами ключ-значение
        //можно наполнить своими заголовками через метод add
        httpHeaders.add("customer-header", "value-header1");
        //HttpHeaders так же предлагает большой выбор стандартных заголовков
        //Посмотрите на них набрав в IDEA HttpHeaders.
        httpHeaders.add(HttpHeaders.FROM, "russia");
        //можно изменить существующий заголовок, вызвав для него сет-метод
        httpHeaders.setDate(0);
        //или получить значение конкретного заголовка
        Long date = httpHeaders.getDate();
        System.out.println(date);
        return ResponseEntity
                .ok().headers(httpHeaders)//здесь метод принимающий MultiValueMap<String, String>
                .body(HttpStatus.OK);
    }





}

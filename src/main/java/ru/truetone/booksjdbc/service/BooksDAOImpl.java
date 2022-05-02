package ru.truetone.booksjdbc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.truetone.booksjdbc.busines.BooksBusines;
import ru.truetone.booksjdbc.model.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksDAOImpl implements BooksBusines<Books> {

    // Хранилище клиентов
    private static final Map<Integer,Books> BookHashMap = new HashMap<>();


    // Переменная для генерации ID клиента
    private static final AtomicInteger Books_ID = new AtomicInteger();


    final String GET_QUERY = "select id,isbn,name,author,pages,price from books";

    JdbcTemplate jdbcTemplate;

    public BooksDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public List<Books> getBooks() {
        return jdbcTemplate.query(GET_QUERY,new BooksRowMapper());
    }

    @Override
    public void create(Books books) {
        final int booksId = Books_ID.incrementAndGet();
        books.setId(booksId);
        BookHashMap.put(booksId,books);
    }

    @Override
    public List<Books> readAll() {
        return new ArrayList<>(BookHashMap.values());
    }

    @Override
    public Books read(int id) {
        return BookHashMap.get(id);
    }

    @Override
    public boolean update(Books books, int id) {
        if (BookHashMap.containsKey(id)){
            books.setId(id);
            BookHashMap.put(id,books);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return BookHashMap.remove(id) != null;
    }
}

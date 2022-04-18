package ru.truetone.booksjdbc.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.truetone.booksjdbc.busines.BooksBusines;
import ru.truetone.booksjdbc.model.Books;

import java.util.List;

@Service
public class BooksDAO implements BooksBusines<Books> {

    final String GET_QUERY = "select id,isbn,name,author,pages,price from books";

    JdbcTemplate jdbcTemplate;

    public BooksDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Books> getBooks() {
        return jdbcTemplate.query(GET_QUERY,new BooksRowMapper());
    }
}

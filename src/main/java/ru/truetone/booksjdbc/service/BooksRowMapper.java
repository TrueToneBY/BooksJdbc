package ru.truetone.booksjdbc.service;

import org.springframework.jdbc.core.RowMapper;
import ru.truetone.booksjdbc.model.Books;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksRowMapper implements RowMapper<Books> {
    @Override
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {

        Books books = new Books();

        books.setId(rs.getInt("id"));
        books.setIsbn(rs.getString("isbn"));
        books.setName(rs.getString("name"));
        books.setAuthor(rs.getString("author"));
        books.setPages(rs.getInt("pages"));
        books.setPrice(rs.getBigDecimal("price"));

        return books;
    }
}

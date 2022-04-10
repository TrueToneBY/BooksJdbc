package ru.truetone.booksjdbc.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Books {

    private Integer id;
    private String isbn;
    private String name;
    private String author;
    private Integer pages;
    private BigDecimal price;
}

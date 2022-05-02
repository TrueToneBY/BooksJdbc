package ru.truetone.booksjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @NotNull
    private Integer id;
    @Min(5)
    @Max(20)
    private String isbn;
    @Max(10)
    private String name;
    @Max(10)
    private String author;
    @Max(1000)
    private Integer pages;
    @Min(1)
    private BigDecimal price;
}

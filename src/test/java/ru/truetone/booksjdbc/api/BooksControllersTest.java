package ru.truetone.booksjdbc.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BooksControllers.class)
class BooksControllersTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    RequestBuilder getAllBooks() throws Exception{
        mockMvc.perform(getAllBooks())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1"));
        return getAllBooks();
    }
}
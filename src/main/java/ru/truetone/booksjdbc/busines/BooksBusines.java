package ru.truetone.booksjdbc.busines;

import ru.truetone.booksjdbc.model.Books;

import java.util.List;

public interface BooksBusines<k> {

    List<Books> getBooks();

    /**
     * Создает нового клиента
     * @param books - клиент для создания
     */
    void create(Books books);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Books> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Books read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param books - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Books books, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);



}

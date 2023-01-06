package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    Book findById(Integer id);

    List<Book> findAll();
    public Book insert(Book books);
    public Book update(Book books);
    public void delete(Integer id);

}
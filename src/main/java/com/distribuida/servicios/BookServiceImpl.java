package com.distribuida.servicios;

import com.distribuida.db.Book;
import com.distribuida.repositories.BookRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService{

    @Inject
    private DataSource dataSource;

    private Jdbi jdbi;

    @PostConstruct
    public void init(){
        jdbi = Jdbi.create(dataSource)
                .installPlugin(new SqlObjectPlugin());
    }

    public Book findById (Integer id){
        return jdbi.withExtension(BookRepository.class, extension -> extension.findById(id));
    }
    @Override
    public List<Book> findAll(){
        return jdbi.withExtension(BookRepository.class, BookRepository::findAll);
    }

    @Override
    public Book insert(Book books) {
        jdbi.useHandle(handle ->
                handle.createUpdate("insert into books (isbn, title, author, price) values (:isbn, :title, :author, :price)")
                        .bind("id",books.getId())
                        .bind("isbn", books.getIsbn())
                        .bind("title", books.getTitle())
                        .bind("author", books.getAuthor())
                        .bind("price", books.getPrice()).execute());
        return books;

    }

    @Override
    public Book update(Book books) {
        jdbi.useHandle(handle ->
                handle.createUpdate("update books set isbn=:isbn , title = :title,  author=:author, price=:price where id = :id")
                        .bind("isbn", books.getIsbn())
                        .bind("title", books.getTitle())
                        .bind("author", books.getAuthor())
                        .bind("price", books.getPrice()).execute());
        return books;
    }

    @Override
    public void delete(Integer id) {

        jdbi.useHandle(handle ->
                handle.createUpdate("delete from books where id = :id")
                        .bind("id", id));

    }


}

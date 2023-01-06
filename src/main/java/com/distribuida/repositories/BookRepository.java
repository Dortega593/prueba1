package com.distribuida.repositories;
import com.distribuida.db.Book;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import java.util.List;

@RegisterBeanMapper(Book.class)
public interface BookRepository {
    @SqlQuery("select * from books")
    List<Book> findAll();

    @SqlQuery("select * from books where id = :id")
    Book findById(@Bind("id") int id);

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("insert into books (isbn, title, author, price) values (:isbn, :title, :author, :price)")
    int insert(@BindBean Book books);

    @Transaction
    @SqlUpdate("update books set isbn=:isbn , title = :title,  author=:author, price=:price where id = :id")
    int update(@BindBean Book books);

    @Transaction
    @SqlUpdate("delete from books where id = :id")
    int deleteById(@Bind("id") int id);
}

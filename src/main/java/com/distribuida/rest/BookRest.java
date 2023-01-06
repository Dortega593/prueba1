package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.List;

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject private BookService bookService;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer  id){
        return bookService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll(){
        return Collections.emptyList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Book books){
        bookService.insert(books);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Book books){
        bookService.update(books);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Integer id){
        bookService.delete(id);
    }

}

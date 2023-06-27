package com.example.demo.application;

import com.example.demo.domain.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/api/books")
public class BookController {
  private final List<Book> books = new ArrayList<>();

  @POST
  @Consumes(MediaType.APPLICATION_JSON) // tipo de dados consumido
  @Produces(MediaType.APPLICATION_JSON) // tipo de dado enviado como resposta
  public Response add(Book book) {
    books.add(book);
    return Response.ok(book).build();
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAll() {
    return Response.ok(books).build();
  }
}

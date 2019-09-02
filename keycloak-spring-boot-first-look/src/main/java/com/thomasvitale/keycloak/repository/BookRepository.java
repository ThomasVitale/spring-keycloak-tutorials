package com.thomasvitale.keycloak.repository;

import com.thomasvitale.keycloak.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {
    private static Map<String, Book> books = new ConcurrentHashMap<>();

    static {
        books.put("B01", new Book("B01", "Harry Potter and the Deathly Hallows", "J.K. Rowling"));
        books.put("B02", new Book("B02", "The Lord of the Rings", "J.R.R. Tolkien"));
        books.put("B03", new Book("B03", "War and Peace", "Leo Tolstoy"));
    }

    public List<Book> readAll() {
        List<Book> allBooks = new ArrayList<>(books.values());
        allBooks.sort(Comparator.comparing(Book::getId));
        return allBooks;
    }

    public void create(Book book) {
        books.put(book.getId(), book);
    }

    public Book read(String id) {
        return books.get(id);
    }

    public void update(Book book) {
        books.put(book.getId(), book);
    }

    public void delete(String id) {
        books.remove(id);
    }
}

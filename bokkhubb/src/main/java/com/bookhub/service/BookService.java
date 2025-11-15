package com.bookhub.service;

import com.bookhub.dao.BookDAO;
import com.bookhub.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO dao;

    public void addOrUpdate(Book b) { dao.saveOrUpdate(b); }
    public List<Book> getAll() { return dao.findAll(); }
    public Book getById(int id) { return dao.findById(id); }
    public void remove(int id) { dao.deleteById(id); }
}

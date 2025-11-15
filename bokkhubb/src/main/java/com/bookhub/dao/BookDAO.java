package com.bookhub.dao;

import com.bookhub.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session current() { return sessionFactory.getCurrentSession(); }

    @Transactional
    public void saveOrUpdate(Book book) {
        if (book.getBookId() == 0) current().persist(book);
        else current().merge(book);
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return current().createQuery("from Book", Book.class).list();
    }

    @Transactional(readOnly = true)
    public Book findById(int id) {
        return current().get(Book.class, id);
    }

    @Transactional
    public void deleteById(int id) {
        Book b = findById(id);
        if (b != null) current().remove(b);
    }
}

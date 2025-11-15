package com.bookhub.controller;

import com.bookhub.model.Book;
import com.bookhub.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/add")
    public String form(Model m) {
        m.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Book b) {
        service.addOrUpdate(b);
        return "redirect:/books/list";
    }

    @GetMapping("/list")
    public String list(Model m) {
        m.addAttribute("books", service.getAll());
        return "viewBooks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.remove(id);
        return "redirect:/books/list";
    }
}
